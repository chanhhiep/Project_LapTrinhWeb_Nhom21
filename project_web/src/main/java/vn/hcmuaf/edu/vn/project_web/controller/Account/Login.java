package vn.hcmuaf.edu.vn.project_web.controller.Account;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.UserService;
import vn.hcmuaf.edu.vn.project_web.beans.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User usr = UserService.CheckLogin(username,password);
        if (usr != null)
        {
            if (usr.active == 0)
            {
                request.setAttribute("error", "username is exits or error system");
                request.getRequestDispatcher("./LoginPage").forward(request, response);
            }
            if (usr.role == "admin")
            {
                request.setAttribute("error", "admin can't login to website");
                request.getRequestDispatcher("./LoginPage").forward(request, response);
            }
            else
            {
                HttpSession session = request.getSession();
                session.setAttribute("auth",usr);
                session.setAttribute("UserId",usr.user_id);
                session.setAttribute("UserName",usr.username);
                session.setAttribute("password",usr.password);
                session.setAttribute("email",usr.email);
                session.setAttribute("customer",usr.customer_id);
                System.out.println(usr.username);
                response.sendRedirect("./home.jsp");
            }
        }
        else
        {
            request.setAttribute("error", "username is exits or error system");
        }
    }
}
