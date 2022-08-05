package vn.hcmuaf.edu.vn.project_web.controller.Admin.size;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.SizeAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SizeAdminController", value = "/SizeAdminController")
public class SizeAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("sizes_admin", SizeAdminService.getInstance().getAllSize());
        request.getRequestDispatcher("/admin/admin_size.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
