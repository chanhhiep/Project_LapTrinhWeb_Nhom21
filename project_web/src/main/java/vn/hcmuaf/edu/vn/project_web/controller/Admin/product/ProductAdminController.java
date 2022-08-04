package vn.hcmuaf.edu.vn.project_web.controller.Admin.product;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ProductAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductAdminController", value = "/ProductAdminController")
public class ProductAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products_admin", ProductAdminService.getInstance().getAllProduct());
        request.getRequestDispatcher("/admin/admin_product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
