package vn.hcmuaf.edu.vn.project_web.controller.Admin.color;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ColorAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ColorAdminController", value = "/ColorAdminController")
public class ColorAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("colors_admin", ColorAdminService.getInstance().getAllColor());
        request.getRequestDispatcher("/admin/admin_color.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
