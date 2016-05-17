package controllers.employees;


import database.DataService;
import entities.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "EmployeesNewController", urlPatterns = {"/admin-employees-new.php"})
public class EmployeesNewController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        req.setAttribute("ranks", dataService.loadAllRanks());
        req.setAttribute("currentPage", "employees-new.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setName(req.getParameter("name"));
        employee.setSurname(req.getParameter("surname"));
        try {
            employee.setSignDate(Date.valueOf(req.getParameter("date")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        employee.setRank(req.getParameter("rank"));
        DataService dataService = new DataService();
        dataService.addNewEmployee(employee);
        req.setAttribute("employees",dataService.loadAllEmployees());
        req.setAttribute("currentPage", "employees.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);

    }
}