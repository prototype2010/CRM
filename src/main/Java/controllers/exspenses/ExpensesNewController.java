package controllers.exspenses;

import database.DataService;
import entities.Expense;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ExpensesNewController", urlPatterns = {"/admin-expenses-new.php"})
public class ExpensesNewController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("currentPage", "expenses-new.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Expense expense= new Expense();
        expense.setType(req.getParameter("type"));
        expense.setSum(Integer.parseInt(req.getParameter("sum")));
        expense.setExpenseDate(Date.valueOf(req.getParameter("date")));
        expense.setComment(req.getParameter("comment"));
        DataService dataService=new DataService();
        dataService.addNewExpense(expense);
        req.setAttribute("expenses",dataService.loadAllExpenses());
        req.setAttribute("currentPage", "expenses.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);
    }
}