package vn.hcmuaf.edu.vn.project_web.controller.Admin.color;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ColorAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveColorController", value = "/SaveColorController")
public class SaveColorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color_id = request.getParameter("color_id");
        String color_name = request.getParameter("color_name");
        if(ColorAdminService.getInstance().SaveColor(color_id,color_name)){
            response.sendRedirect("./ColorAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher(".ColorAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
