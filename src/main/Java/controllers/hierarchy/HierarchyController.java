package controllers.hierarchy;


import database.DataService;
import entities.AbstractEmployee;
import entities.AbstractRank;
import entities.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "HierarchyController", urlPatterns = {"/admin-hierarchy.php"})
public class HierarchyController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataService dataService = new DataService();
        List<AbstractEmployee> employees = dataService.loadAllEmployeesBonus();
        List<AbstractEmployee> ceos = new LinkedList<>();
        List<AbstractEmployee> managers = new LinkedList<>();
        List<AbstractEmployee> clerks = new LinkedList<>();
        for (int i = 0, j = employees.size(); i < j; i++) {
            if (employees.get(i).getRank().equals("CEO")) {
                ceos.add(employees.get(i));
            } else if (employees.get(i).getRank().equals("Manager")) {
                managers.add(employees.get(i));
            } else {
                clerks.add(employees.get(i));
            }
        }
        req.setAttribute("ceos", ceos);
        req.setAttribute("managers", managers);
        req.setAttribute("clerks", clerks);
        List<AbstractRank> ranks = dataService.loadRanksAndBonus();
        List<AbstractRank> ceo = new LinkedList<>();
        List<AbstractRank> manager = new LinkedList<>();
        List<AbstractRank> clerk = new LinkedList<>();

        for (int i = 0, j = ranks.size(); i < j; i++) {
            if (ranks.get(i).getName().equals("CEO")) {
                ceo.add(ranks.get(i));
            } else if (ranks.get(i).getName().equals("Manager")) {
                manager.add(ranks.get(i));
            } else {
                clerk.add(ranks.get(i));
            }
        }
        req.setAttribute("ceo", ceo.get(0).getBonus());
        req.setAttribute("manager", manager.get(0).getBonus());
        req.setAttribute("clerk", clerk.get(0).getBonus());
        req.setAttribute("currentPage", "hierarchy.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        dataService.changeMotivation(req.getParameter("ceo"),req.getParameter("manager"),req.getParameter("clerk"));
        List<AbstractEmployee> employees = dataService.loadAllEmployeesBonus();
        List<AbstractEmployee> ceos = new LinkedList<>();
        List<AbstractEmployee> managers = new LinkedList<>();
        List<AbstractEmployee> clerks = new LinkedList<>();
        for (int i = 0, j = employees.size(); i < j; i++) {
            if (employees.get(i).getRank().equals("CEO")) {
                ceos.add(employees.get(i));
            } else if (employees.get(i).getRank().equals("Manager")) {
                managers.add(employees.get(i));
            } else {
                clerks.add(employees.get(i));
            }
        }
        req.setAttribute("ceos", ceos);
        req.setAttribute("managers", managers);
        req.setAttribute("clerks", clerks);
        List<AbstractRank> ranks = dataService.loadRanksAndBonus();
        List<AbstractRank> ceo = new LinkedList<>();
        List<AbstractRank> manager = new LinkedList<>();
        List<AbstractRank> clerk = new LinkedList<>();

        for (int i = 0, j = ranks.size(); i < j; i++) {
            if (ranks.get(i).getName().equals("CEO")) {
                ceo.add(ranks.get(i));
            } else if (ranks.get(i).getName().equals("Manager")) {
                manager.add(ranks.get(i));
            } else {
                clerk.add(ranks.get(i));
            }
        }
        req.setAttribute("ceo", ceo.get(0).getBonus());
        req.setAttribute("manager", manager.get(0).getBonus());
        req.setAttribute("clerk", clerk.get(0).getBonus());
        req.setAttribute("currentPage", "hierarchy.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);

    }
}