package vn.hcmuaf.edu.vn.project_web.controller.Admin.user;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.UserAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUserController", value = "/DeleteUserController")
public class DeleteUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id_delete");
        if(UserAdminService.getInstance().DeleteUserById(user_id)){
            response.sendRedirect("./UserAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./UserAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
