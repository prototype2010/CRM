package controllers.contracts;

import database.DataService;
import entities.Agent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Boris on 08.05.2016.
 */
@WebServlet(name = "ContractsNewController", urlPatterns = {"/admin-contracts-new.php"})
public class ContractsNewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setAttribute("currentPage", "contracts-new.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Agent agent=new Agent();
        agent.setName(req.getParameter("name"));
        agent.setInfo(req.getParameter("info"));
        DataService dataService= new DataService();
        dataService.addNewAgent(agent);
        req.setAttribute("agents", dataService.loadAllAgents());
        req.setAttribute("currentPage", "contracts.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);
    }
}