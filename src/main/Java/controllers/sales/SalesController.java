package controllers.sales;


import database.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "SalesController", urlPatterns = {"/admin-sales.php","/user-sales.php"})
public class SalesController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataService dataService=new DataService();
        req.setAttribute("sales",dataService.loadAllSales());
        req.setAttribute("currentPage", "sales.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        DataService dataService=new DataService();
        req.setAttribute("sales",dataService.loadAllSalesByDate(req.getParameter("lowDate"),req.getParameter("highDate")));
        req.setAttribute("currentPage", "sales.jsp");
        req.setAttribute("lowDate",req.getParameter("lowDate"));
        req.setAttribute("highDate",req.getParameter("highDate"));
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);
    }
}
