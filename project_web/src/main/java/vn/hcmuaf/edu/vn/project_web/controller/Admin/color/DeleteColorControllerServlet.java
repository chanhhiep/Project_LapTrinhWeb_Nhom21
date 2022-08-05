package vn.hcmuaf.edu.vn.project_web.controller.Admin.color;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ColorAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteColorControllerServlet", value = "/DeleteColorController")
public class DeleteColorControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color_id = request.getParameter("color_id_delete");
        if(ColorAdminService.getInstance().DeleteColorById(color_id)){
            response.sendRedirect("./ColorAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./ColorAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
