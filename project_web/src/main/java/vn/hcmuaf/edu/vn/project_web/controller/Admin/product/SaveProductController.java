package vn.hcmuaf.edu.vn.project_web.controller.Admin.product;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ProductAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveProductController", value = "/SaveProductController")
public class SaveProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_id = request.getParameter("product_id");
        System.out.println(product_id);
        String product_name = request.getParameter("product_name");
        String category_id= request.getParameter("category_id");
        double product_price = Double.parseDouble(request.getParameter("product_price"));
        String promotion_id = request.getParameter("promotion_id");
        String brand = request.getParameter("brand");
        int i_quantity = Integer.parseInt(request.getParameter("i_quantity"));
        String description = request.getParameter("description");
        if(ProductAdminService.getInstance().SaveProduct(product_id,product_name,category_id,product_price,promotion_id,brand,i_quantity,description)){
            response.sendRedirect("./ProductAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./ProductAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
