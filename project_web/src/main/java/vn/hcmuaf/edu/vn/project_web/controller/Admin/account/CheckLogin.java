package vn.hcmuaf.edu.vn.project_web.controller.Admin.account;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.UserAdminService;
import vn.hcmuaf.edu.vn.project_web.Service.MainService.UserService;
import vn.hcmuaf.edu.vn.project_web.beans.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckLogin", value = "/CheckLogin")
public class CheckLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User usr = UserAdminService.CheckLogin(username,password);
        if (usr != null)
        {
            if (usr.active == 0)
            {
                request.setAttribute("error", "username is exits or error system");
                request.getRequestDispatcher("./LoginAdminController").forward(request, response);
            }
            if (usr.role.equals("customer"))
            {
                request.setAttribute("error", "customer can't login to website");
                request.getRequestDispatcher("./LoginAdminController").forward(request, response);
            }
            else
            {
                HttpSession session = request.getSession();
                session.setAttribute("admin_auth",usr);
                session.setAttribute("admin_UserId",usr.user_id);
                session.setAttribute("admin_username",usr.username);
                session.setAttribute("admin_password",usr.password);
                session.setAttribute("admin_role",usr.role);
                System.out.println(usr.username);
                response.sendRedirect("./DashboardAdminController");
            }
        }
        else
        {
            request.setAttribute("error", "username is not exits or error system");
            request.getRequestDispatcher("./LoginAdminController").forward(request, response);
        }
    }
}
