package vn.hcmuaf.edu.vn.project_web.controller.Admin.customer;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.CustomerAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerAdminController", value = "/CustomerAdminController")
public class CustomerAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers_admin", CustomerAdminService.getInstance().getAllCustomer());
        request.getRequestDispatcher("/admin/admin_customer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
