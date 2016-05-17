package controllers.service;

import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import database.DataService;
import entities.Account;
import entities.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Boris on 08.05.2016.
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login.php"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataService data = new DataService();
        List<Role> roles = data.loadAllRoles();
        req.setAttribute("roles", roles);
        req.setAttribute("currentPage", "login.jsp");
        req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = new Account();
        account.setLogin(req.getParameter("login"));
        account.setPassword(req.getParameter("password"));
        String role = req.getParameter("role");
        String roleByLogin = "";
        DataService dataService = new DataService();
        String passwordByLogin = dataService.getPasswordBylogin(account.getLogin());
        String roleByLogin1 = "";
        String roleByLogin2 = "";
        String roleByLogin3 = "";

        if (account.getPassword().equals(passwordByLogin)) {
            //password and login are correct
            roleByLogin = dataService.getRoleByAccount(account.getLogin());
            if (role.equals(roleByLogin)) {
                //role and pass are correct

                //todo set role to session
                req.setAttribute("currentPage","main.jsp");
                req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);

            } else {
                // set error message here because role is incorrect
                DataService data = new DataService();
                List<Role> roles = data.loadAllRoles();
                req.setAttribute("roles", roles);
                req.setAttribute("errorMessage","Role doesn't match to your account");
                req.setAttribute("currentPage","login.jsp");
                req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);
            }
        } else {
            // error message because password or login is incorrect (or both )
            DataService data = new DataService();
            List<Role> roles = data.loadAllRoles();
            req.setAttribute("roles", roles);
            req.setAttribute("errorMessage","Login or password is incorrect");
            req.setAttribute("currentPage","login.jsp");
            req.getRequestDispatcher("WEB-INF/jsp/template.jsp").forward(req, resp);

        }

    }
}
