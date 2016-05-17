package controllers.exspenses;

import database.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExpensesDeletedController", urlPatterns = {"/admin-expenses-deleted.php"})
public class ExpensesDeletedController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataService dataService=new DataService();
        req.setAttribute("expenses", dataService.loadAllDeletedExpenses());
        req.setAttribute("currentPage", "expenses-deleted.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService=new DataService();
        req.setAttribute("expenses",dataService.loadAllDeletedExpensesByDate(req.getParameter("lowDate"),req.getParameter("highDate")));
        req.setAttribute("lowDate",req.getParameter("lowDate"));
        req.setAttribute("highDate",req.getParameter("highDate"));
        req.setAttribute("currentPage", "expenses-deleted.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);
    }
}
