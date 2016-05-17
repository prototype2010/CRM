package controllers.employees;


import database.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeesDeletedController", urlPatterns = {"/admin-employees-deleted.php"})
public class EmployeesDeletedController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataService dataService= new DataService();
        req.setAttribute("employees", dataService.loadallDeletedEmployees());
        req.setAttribute("currentPage", "employees-deleted.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}