package database;

import constants.Constants;
import entities.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Boris on 08.05.2016.
 */
public class DataService implements Constants {
    private static List<DatabaseConnection> list=new LinkedList<>();

    public void init() {
        for ( int i=0;i<CONNECTION_POOL_SIZE;i++) {
           newConnection();
        }
    }
    private void newConnection() {
        DatabaseConnection conn=new DatabaseConnection(Constants.URL_TO_DATABASE);
        list.add(conn);
    }

    public List<Role> loadAllRoles() {
        DatabaseConnection conn=list.remove(0);
        List<Role> roles=conn.loadAllRoles();
        list.add(conn);
        return roles;
    }
    public String getPasswordBylogin(String login) {
        DatabaseConnection conn=list.remove(0);
        String password=conn.getPasswordByLogin(login);
        list.add(conn);
        return password;
    }
    public String getRoleByAccount (String login) {
        DatabaseConnection conn=list.remove(0);
        String role=conn.getRoleByLogin(login);
        list.add(conn);
        return role;
    }

    public List<Employee> loadAllEmployees() {
        DatabaseConnection conn=list.remove(0);
        List<Employee> employees=conn.loadAllEmployees();
        list.add(conn);
        return employees;
    }
    public List<Rank> loadAllRanks() {
        DatabaseConnection conn=list.remove(0);
        List<Rank> ranks=conn.loadAllRanks();
        list.add(conn);
        return ranks;
    }

    public void addNewEmployee(Employee employee) {
        DatabaseConnection conn=list.remove(0);
        conn.addNewEmployee(employee);
        list.add(conn);
    }

    public void addNewAgent(Agent agent) {
        DatabaseConnection conn=list.remove(0);
        conn.addNewAgent(agent);
        list.add(conn);
    }

    public List<Agent> loadAllAgents() {
        DatabaseConnection conn=list.remove(0);
        List<Agent> agents=conn.loadAllAgents();
        list.add(conn);
        return agents;
    }

    public void addNewSale(Sale sale) {
        DatabaseConnection conn=list.remove(0);
        conn.addNewSale(sale);
        list.add(conn);

    }
    public List<AbstractSale> loadAllSales() {
        DatabaseConnection conn=list.remove(0);
        List<AbstractSale> sales=conn.loadAllSales();
        list.add(conn);
        return sales;

    }
    public List<AbstractSale> loadAllSalesByDate(String lowDate, String highDate) {
        DatabaseConnection conn=list.remove(0);
        List<AbstractSale> sales=conn.loadAllSalesByDate(lowDate,highDate);
        list.add(conn);
        return sales;
    }
    public List<AbstractSale> loadAllDeletedSales() {
        DatabaseConnection conn=list.remove(0);
        List<AbstractSale> sales=conn.loadAllDeletedSales();
        list.add(conn);
        return sales;
    }
    public List<AbstractSale> loadAllDeletedSalesByDate(String lowDate, String highDate) {
        DatabaseConnection conn=list.remove(0);
        List<AbstractSale> sales=conn.loadAllDeletedSalesByDate(lowDate, highDate);
        list.add(conn);
        return sales;
    }

    public List<Employee> loadallDeletedEmployees() {
        DatabaseConnection conn=list.remove(0);
        List<Employee> employees=conn.loadAllDeletedEmployees();
        list.add(conn);
        return employees;

    }


    public void addNewExpense(Expense expense) {
        DatabaseConnection conn=list.remove(0);
        conn.addNewExpense(expense);
        list.add(conn);
    }

    public List<Expense> loadAllExpenses() {
        DatabaseConnection conn=list.remove(0);
        List<Expense> expenses=conn.loadAllExpenses();
        list.add(conn);
        return expenses;
    }

    public List<Expense> loadAllExpensesByDate(String lowDate, String highDate) {
        DatabaseConnection conn=list.remove(0);
        List<Expense> expenses=conn.loadAllExpensesByDate(lowDate, highDate);
        list.add(conn);
        return expenses;
    }

    public List<Expense> loadAllDeletedExpenses() {
        DatabaseConnection conn=list.remove(0);
        List<Expense> expenses=conn.loadAllDeletedExpenses();
        list.add(conn);
        return expenses;
    }

    public List<Expense> loadAllDeletedExpensesByDate(String lowDate, String highDate) {
        DatabaseConnection conn=list.remove(0);
        List<Expense> expenses=conn.loadAllDeletedExpensesByDate(lowDate, highDate);
        list.add(conn);
        return expenses;
    }

    public List<Agent> loadAllDeletedAgents() {
        DatabaseConnection conn=list.remove(0);
        List<Agent> agents=conn.loadAllDeletedAgents();
        list.add(conn);
        return agents;
    }

    public List<AbstractEmployee> loadAllEmployeesBonus() {
        DatabaseConnection conn=list.remove(0);
        List<AbstractEmployee> employees=conn.loadAllEmployeesBonus();
        list.add(conn);
        return employees;
    }

    public List<AbstractRank> loadRanksAndBonus() {
        DatabaseConnection conn=list.remove(0);
        List<AbstractRank> ranks=conn.loadAllRanksAndBonus();
        list.add(conn);
        return ranks;
    }

    public void changeMotivation(String ceo, String manager, String clerk) {
        DatabaseConnection conn=list.remove(0);
        conn.changeMotivation(ceo,manager,clerk);
        list.add(conn);
    }
}
