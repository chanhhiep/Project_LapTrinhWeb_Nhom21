package vn.hcmuaf.edu.vn.project_web.controller.Admin.product;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ProductAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteProductController", value = "/DeleteProductController")
public class DeleteProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_id = request.getParameter("product_id_delete");
        if(ProductAdminService.getInstance().DeleteProductById(product_id)){
            response.sendRedirect("./ProductAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./ProductAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
