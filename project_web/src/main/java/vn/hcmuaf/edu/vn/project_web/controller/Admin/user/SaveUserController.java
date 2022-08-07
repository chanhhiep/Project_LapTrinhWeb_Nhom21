package vn.hcmuaf.edu.vn.project_web.controller.Admin.user;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.UserAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveUserController", value = "/SaveUserController")
public class SaveUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_name = request.getParameter("user_name");
        String password = request.getParameter("user_password");
        String email = request.getParameter("user_email");
        String customer_id = request.getParameter("user_customer");
        if(UserAdminService.getInstance().SaveUser(user_name,password,email,customer_id)){
            response.sendRedirect("./UserAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./UserAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
