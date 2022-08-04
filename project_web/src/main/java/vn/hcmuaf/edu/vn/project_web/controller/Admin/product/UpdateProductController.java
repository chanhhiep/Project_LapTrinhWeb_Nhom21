package vn.hcmuaf.edu.vn.project_web.controller.Admin.product;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ProductAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateProductController", value = "/UpdateProductController")
public class UpdateProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_id = request.getParameter("product_id_update");
        String product_name = request.getParameter("product_name_update");
        String category_id= request.getParameter("category_id_update");
        double product_price = Double.parseDouble(request.getParameter("product_price_update"));
        String promotion_id = request.getParameter("promotion_id_update");
        String brand = request.getParameter("brand_update");
        int i_quantity = Integer.parseInt(request.getParameter("i_quantity_update"));
        String description = request.getParameter("description_update");
        int active = Integer.parseInt(request.getParameter("active"));
        if(ProductAdminService.getInstance().UpdateProductById(product_id,product_name,category_id,product_price,promotion_id,brand,i_quantity,description,active)){
            response.sendRedirect("./ProductAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./ProductAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
