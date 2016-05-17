package controllers.contracts;

/**
 * Created by Boris on 08.05.2016.
 */

import database.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContractsController", urlPatterns = {"/admin-contracts.php"})
public class ContractsController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataService dataService=new DataService();
        req.setAttribute("agents", dataService.loadAllAgents());
        req.setAttribute("currentPage", "contracts.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}