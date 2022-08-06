package vn.hcmuaf.edu.vn.project_web.controller.Admin.user;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.UserAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateUserController", value = "/UpdateUserController")
public class UpdateUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id_update");
        String user_name = request.getParameter("user_name_update");
        String password = request.getParameter("user_password_update");
        String role = request.getParameter("user_role_update");
        String email = request.getParameter("user_email_update");
        String customer_id = request.getParameter("user_customer_update");
        int active = Integer.parseInt(request.getParameter("user_active_update"));
        if(UserAdminService.getInstance().UpdateUserById(user_id,user_name,password,role,email,customer_id,active)){
            response.sendRedirect("./UserAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./UserAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
