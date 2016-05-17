package database;

import constants.Constants;
import entities.*;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Boris on 08.05.2016.
 */
public class DatabaseConnection implements Constants {

    private Connection conn;
    private ResultSet rs;
    private static PreparedStatement loadAllRoles;
    private static PreparedStatement getPasswordByLogin;
    private static PreparedStatement getRoleByLogin;
    private static PreparedStatement loadAllEmployees;
    private static PreparedStatement loadAllRanks;
    private static PreparedStatement addNewEmployee;
    private static PreparedStatement addNewAgent;
    private static PreparedStatement loadAllAgents;
    private static PreparedStatement addNewSale;
    private static PreparedStatement loadAllSales;
    private static PreparedStatement loadAllSalesByDate;
    private static PreparedStatement loadAllDeletedSales;
    private static PreparedStatement loadAllDeletedSalesByDate;
    private static PreparedStatement loadAllDeletedEmployees;
    private static PreparedStatement addNewExpense;
    private static PreparedStatement loadAllExpenses;
    private static PreparedStatement loadAllExpensesByDate;
    private static PreparedStatement loadAllDeletedExpenses;
    private static PreparedStatement loadAllDeletedExpensesByDate;
    private static PreparedStatement loadAllDeletedAgents;
    private static PreparedStatement loadAllEmployeesBonus;
    private static PreparedStatement loadAllRolesAndBonus;
    private static PreparedStatement changeMotivation;


    public DatabaseConnection(String urlToDatabase) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL_TO_DATABASE);
            loadPreparedStatements();
        } catch (Exception e) {

        }
    }

    private void loadPreparedStatements() {
        try {
            loadAllRoles = conn.prepareStatement("SELECT * FROM role WHERE status=1");
            getPasswordByLogin = conn.prepareStatement("SELECT password FROM accounts where login=?");
            getRoleByLogin = conn.prepareStatement("SELECT role FROM role WHERE id IN( SELECT role_id FROM" +
                    " link_role_account WHERE account_id IN(SELECT id FROM accounts WHERE login=?))");
            loadAllEmployees = conn.prepareStatement("SELECT * FROM employees WHERE status=1");
            loadAllRanks = conn.prepareStatement("SELECT * FROM ranks WHERE status=1");
            addNewEmployee = conn.prepareStatement("INSERT INTO employees(name,surname,date,rank) VALUES(?,?,?,?)");
            addNewAgent = conn.prepareStatement("INSERT INTO agents(name,info) VALUES (?,?)");
            loadAllAgents = conn.prepareStatement("SELECT a.id,a.name,a.info,(SELECT count(status) FROM sales s" +
                    " WHERE a.id=s.agent_name AND s.status=1 ) AS sales ,(SELECT sum(sum) FROM sales s" +
                    " WHERE a.id=s.agent_name AND s.status=1) AS sum FROM agents a WHERE a.status=1  ");
            addNewSale = conn.prepareStatement("INSERT INTO sales(employee_name,agent_name,sum,date,comment) VALUES(?,?,?,?,?)");
            loadAllSales = conn.prepareStatement("SELECT s.id,e.name,e.surname,e.rank,a.name as agent,s.sum,s.date" +
                    " FROM sales s,employees e,agents a WHERE s.employee_name=e.id AND s.agent_name=a.id");
            loadAllSalesByDate = conn.prepareStatement("SELECT s.id,e.name,e.surname,e.rank,a.name as agent,s.sum,s.date " +
                    "FROM sales s,employees e,agents a WHERE s.employee_name=e.id AND s.agent_name=a.id AND s.date > ? AND s.date < ?;");
            loadAllDeletedSales = conn.prepareStatement("SELECT s.id,e.name,e.surname,e.rank,a.name as agent,s.sum,s.date " +
                    "FROM sales s,employees e,agents a WHERE s.employee_name=e.id AND s.agent_name=a.id AND s.status=0");
            loadAllDeletedSalesByDate = conn.prepareStatement("SELECT s.id,e.name,e.surname,e.rank,a.name as agent,s.sum,s.date " +
                    "FROM sales s,employees e,agents a WHERE s.employee_name=e.id AND s.agent_name=a.id AND s.date > ? AND s.date < ? AND s.status=0;");
            loadAllDeletedEmployees = conn.prepareStatement("SELECT * FROM employees WHERE status=0");
            addNewExpense = conn.prepareStatement("INSERT INTO expenses(date, sum, type, comment) VALUES (?,?,?,?);");
            loadAllExpenses = conn.prepareStatement("SELECT * FROM expenses WHERE status=1;");
            loadAllExpensesByDate = conn.prepareStatement("SELECT * FROM expenses WHERE status=1 AND date > ? AND date < ?");
            loadAllDeletedExpenses=conn.prepareStatement("SELECT * FROM expenses WHERE status=0;");
            loadAllDeletedExpensesByDate=conn.prepareStatement("SELECT * FROM expenses WHERE status=0 AND date > ? AND date < ?");
            loadAllDeletedAgents=conn.prepareStatement("SELECT a.id,a.name,a.info,(SELECT count(status) FROM sales s " +
                    "WHERE a.id=s.agent_name AND s.status=1 ) AS sales ,(SELECT sum(sum) FROM sales s" +
                    " WHERE a.id=s.agent_name AND s.status=1) AS sum FROM agents a WHERE a.status=0 ");
            loadAllEmployeesBonus=conn.prepareStatement("SELECT e.id,e.name,e.surname,e.rank,(SELECT bonus FROM ranks r " +
                    "WHERE e.rank=r.rank) AS bonus FROM employees e WHERE e.status=1 ORDER BY e.rank ");
            loadAllRolesAndBonus=conn.prepareStatement("SELECT DISTINCT rank,bonus,id FROM ranks WHERE status=1 ");
            changeMotivation=conn.prepareStatement("UPDATE ranks SET bonus=? WHERE rank=? ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Role> loadAllRoles() {
        rs = null;
        List<Role> roles = new LinkedList<>();
        try {
            rs = loadAllRoles.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setRole(rs.getString("role"));
                if (rs.getInt("status") == 1) {
                    role.setStatus(true);
                }
                roles.add(role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;

    }

    public String getPasswordByLogin(String login) {
        rs = null;
        String password = "";
        try {
            PreparedStatement query = getPasswordByLogin;
            query.setString(1, login);
            rs = getPasswordByLogin.executeQuery();
            while (rs.next()) {
                password = rs.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }

    public String getRoleByLogin(String login) {
        rs = null;
        String role = "";
        try {
            PreparedStatement query = getRoleByLogin;
            query.setString(1, login);
            rs = getRoleByLogin.executeQuery();
            while (rs.next()) {
                role = rs.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public List<Employee> loadAllEmployees() {
        rs = null;
        List<Employee> employees = new LinkedList<>();
        try {
            rs = loadAllEmployees.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setRank(rs.getString("rank"));
                employee.setSignDate(rs.getDate("date"));
                employee.setStatus(true);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<Rank> loadAllRanks() {
        rs = null;
        List<Rank> ranks = new LinkedList<>();
        try {
            rs = loadAllRanks.executeQuery();
            while (rs.next()) {
                Rank rank = new Rank();
                rank.setId(rs.getInt("id"));
                rank.setName(rs.getString("rank"));
                rank.setStatus(true);
                ranks.add(rank);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ranks;
    }

    public void addNewEmployee(Employee employee) {
        try {
            PreparedStatement query = addNewEmployee;
            query.setString(1, employee.getName());
            query.setString(2, employee.getSurname());
            query.setDate(3, employee.getSignDate());
            query.setString(4, employee.getRank());
            //??
            query.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewAgent(Agent agent) {
        try {
            PreparedStatement query = addNewAgent;
            query.setString(1, agent.getName());
            query.setString(2, agent.getInfo());
            query.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Agent> loadAllAgents() {
        rs = null;
        List<Agent> agents = new LinkedList<>();
        try {
            rs = loadAllAgents.executeQuery();
            while (rs.next()) {
                Agent agent = new Agent();
                agent.setId(rs.getInt("id"));
                agent.setName(rs.getString("name"));
                agent.setInfo(rs.getString("info"));
                agent.setSales(rs.getInt("sales"));
                agent.setSum(rs.getInt("sum"));
                agents.add(agent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agents;


    }

    public void addNewSale(Sale sale) {
        try {
            PreparedStatement query = addNewSale;
            query.setInt(1, sale.getEmployeeName());
            query.setInt(2, sale.getAgentName());
            query.setInt(3, sale.getSum());
            query.setDate(4, sale.getSaleDate());
            query.setString(5, sale.getComment());
            query.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AbstractSale> loadAllSales() {
        List<AbstractSale> abstractSales = new LinkedList<>();
        rs = null;
        try {
            rs = loadAllSales.executeQuery();
            while (rs.next()) {
                AbstractSale abstractSale = new AbstractSale();
                abstractSale.setId(rs.getInt("id"));
                abstractSale.setName(rs.getString("name"));
                abstractSale.setSurname(rs.getString("surname"));
                abstractSale.setAgent(rs.getString("agent"));
                abstractSale.setRank(rs.getString("rank"));
                abstractSale.setSum(rs.getInt("sum"));
                abstractSale.setDate(rs.getDate("date"));
                abstractSales.add(abstractSale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abstractSales;

    }

    public List<AbstractSale> loadAllSalesByDate(String lowDate, String highDate) {
        List<AbstractSale> abstractSales = new LinkedList<>();
        rs = null;
        try {
            PreparedStatement query = loadAllSalesByDate;
            query.setDate(1, Date.valueOf(lowDate));
            query.setDate(2, Date.valueOf(highDate));
            rs = loadAllSalesByDate.executeQuery();
            while (rs.next()) {
                AbstractSale abstractSale = new AbstractSale();
                abstractSale.setId(rs.getInt("id"));
                abstractSale.setName(rs.getString("name"));
                abstractSale.setSurname(rs.getString("surname"));
                abstractSale.setAgent(rs.getString("agent"));
                abstractSale.setRank(rs.getString("rank"));
                abstractSale.setSum(rs.getInt("sum"));
                abstractSale.setDate(rs.getDate("date"));
                abstractSales.add(abstractSale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abstractSales;

    }

    public List<AbstractSale> loadAllDeletedSales() {
        List<AbstractSale> abstractSales = new LinkedList<>();
        rs = null;
        try {
            rs = loadAllDeletedSales.executeQuery();
            while (rs.next()) {
                AbstractSale abstractSale = new AbstractSale();
                abstractSale.setId(rs.getInt("id"));
                abstractSale.setName(rs.getString("name"));
                abstractSale.setSurname(rs.getString("surname"));
                abstractSale.setAgent(rs.getString("agent"));
                abstractSale.setRank(rs.getString("rank"));
                abstractSale.setSum(rs.getInt("sum"));
                abstractSale.setDate(rs.getDate("date"));
                abstractSales.add(abstractSale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abstractSales;
    }

    public List<AbstractSale> loadAllDeletedSalesByDate(String lowDate, String highDate) {
        List<AbstractSale> abstractSales = new LinkedList<>();
        rs = null;
        try {
            PreparedStatement query = loadAllDeletedSalesByDate;
            query.setDate(1, Date.valueOf(lowDate));
            query.setDate(2, Date.valueOf(highDate));
            rs = loadAllDeletedSalesByDate.executeQuery();
            while (rs.next()) {
                AbstractSale abstractSale = new AbstractSale();
                abstractSale.setId(rs.getInt("id"));
                abstractSale.setName(rs.getString("name"));
                abstractSale.setSurname(rs.getString("surname"));
                abstractSale.setAgent(rs.getString("agent"));
                abstractSale.setRank(rs.getString("rank"));
                abstractSale.setSum(rs.getInt("sum"));
                abstractSale.setDate(rs.getDate("date"));
                abstractSales.add(abstractSale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abstractSales;

    }

    public List<Employee> loadAllDeletedEmployees() {
        rs = null;
        List<Employee> employees = new LinkedList<>();
        try {
            rs = loadAllDeletedEmployees.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setRank(rs.getString("rank"));
                employee.setSignDate(rs.getDate("date"));
                employee.setStatus(true);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;

    }

    public void addNewExpense(Expense expense) {

        try {
            PreparedStatement query = addNewExpense;
            query.setDate(1, expense.getExpenseDate());
            query.setInt(2, expense.getSum());
            query.setString(3, expense.getType());
            query.setString(4, expense.getComment());
            query.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Expense> loadAllExpenses() {
        rs = null;
        List<Expense> expenses = new LinkedList<>();
        try {
            rs = loadAllExpenses.executeQuery();
            while (rs.next()) {
                Expense expense = new Expense();
                expense.setId(rs.getInt("id"));
                expense.setExpenseDate(rs.getDate("date"));
                expense.setSum(rs.getInt("sum"));
                expense.setType(rs.getString("type"));
                expense.setComment(rs.getString("comment"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    public List<Expense> loadAllExpensesByDate(String lowDate, String highDate) {
        List<Expense> expenses = new LinkedList<>();
        rs = null;
        try {
            PreparedStatement query=loadAllExpensesByDate;
            query.setDate(1,Date.valueOf(lowDate));
            query.setDate(2,Date.valueOf(highDate));
            rs=loadAllExpensesByDate.executeQuery();
            while (rs.next()) {
                 Expense expense=new Expense();
                expense.setId(rs.getInt("id"));
                expense.setType(rs.getString("type"));
                expense.setExpenseDate(rs.getDate("date"));
                expense.setSum(rs.getInt("sum"));
                expense.setComment(rs.getString("comment"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    public List<Expense> loadAllDeletedExpenses() {
        rs = null;
        List<Expense> expenses = new LinkedList<>();
        try {
            rs = loadAllDeletedExpenses.executeQuery();
            while (rs.next()) {
                Expense expense = new Expense();
                expense.setId(rs.getInt("id"));
                expense.setExpenseDate(rs.getDate("date"));
                expense.setSum(rs.getInt("sum"));
                expense.setType(rs.getString("type"));
                expense.setComment(rs.getString("comment"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    public List<Expense> loadAllDeletedExpensesByDate(String lowDate, String highDate) {
        List<Expense> expenses = new LinkedList<>();
        rs = null;
        try {
            PreparedStatement query=loadAllDeletedExpensesByDate;
            query.setDate(1,Date.valueOf(lowDate));
            query.setDate(2,Date.valueOf(highDate));
            rs=loadAllDeletedExpensesByDate.executeQuery();
            while (rs.next()) {
                Expense expense=new Expense();
                expense.setId(rs.getInt("id"));
                expense.setType(rs.getString("type"));
                expense.setExpenseDate(rs.getDate("date"));
                expense.setSum(rs.getInt("sum"));
                expense.setComment(rs.getString("comment"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    public List<Agent> loadAllDeletedAgents() {
        rs = null;
        List<Agent> agents = new LinkedList<>();
        try {
            rs = loadAllDeletedAgents.executeQuery();
            while (rs.next()) {
                Agent agent = new Agent();
                agent.setId(rs.getInt("id"));
                agent.setName(rs.getString("name"));
                agent.setInfo(rs.getString("info"));
                agent.setSales(rs.getInt("sales"));
                agent.setSum(rs.getInt("sum"));
                agents.add(agent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agents;
    }

    public List<AbstractEmployee> loadAllEmployeesBonus() {
        rs = null;
        List<AbstractEmployee> employees = new LinkedList<>();
        try {
            rs = loadAllEmployeesBonus.executeQuery();
            while (rs.next()) {
                AbstractEmployee employee = new AbstractEmployee();
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setRank(rs.getString("rank"));
                employee.setId(rs.getInt("id"));
                employee.setBonus(rs.getDouble("bonus"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<AbstractRank> loadAllRanksAndBonus() {
        rs=null;
        List<AbstractRank> ranks=new LinkedList<>();
        try {
            rs=loadAllRolesAndBonus.executeQuery();
            while(rs.next()) {
                AbstractRank abstractRank=new AbstractRank();
                abstractRank.setId(rs.getInt("id"));
                abstractRank.setName(rs.getString("rank"));
                abstractRank.setBonus(rs.getDouble("bonus"));
                ranks.add(abstractRank);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return ranks;
    }

    public void changeMotivation(String ceo, String manager, String clerk) {
        try{
            PreparedStatement query=changeMotivation;
            query.setDouble(1,Double.parseDouble(ceo));
            query.setString(2,"CEO");
            query.execute();
            PreparedStatement query1=changeMotivation;
            query.setDouble(1,Double.parseDouble(manager));
            query.setString(2,"Manager");
            query.execute();
            PreparedStatement query2=changeMotivation;
            query.setDouble(1,Double.parseDouble(clerk));
            query.setString(2,"Clerk");
            query.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

