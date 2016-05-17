package controllers.sales;


import database.DataService;
import entities.Employee;
import entities.Sale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "SalesNewController", urlPatterns = {"/admin-sales-new.php"})
public class SalesNewController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataService dataService= new DataService();
        List<Employee> employees=dataService.loadAllEmployees();
        req.setAttribute("employees",employees);
        req.setAttribute("agents", dataService.loadAllAgents());
        req.setAttribute("currentPage", "sales-new.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Sale sale=new Sale();
        sale.setEmployeeName(Integer.parseInt(req.getParameter("employee")));
        sale.setAgentName(Integer.parseInt(req.getParameter("agent")));
        sale.setSum(Integer.parseInt(req.getParameter("sum")));
        sale.setComment(req.getParameter("comment"));
        try {
            sale.setSaleDate(Date.valueOf(req.getParameter("date")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        DataService dataService=new DataService();
        dataService.addNewSale(sale);
        req.setAttribute("sales",dataService.loadAllSales());
        req.setAttribute("currentPage", "sales.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);
    }
}
