package vn.hcmuaf.edu.vn.project_web.controller.ProductDetail;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.ProductService;
import vn.hcmuaf.edu.vn.project_web.beans.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductDetailController", value = "/ProductDetailController")
public class ProductDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_id = request.getParameter("product_id");
        request.setAttribute("product_details", ProductService.getInstance().GetProductById(product_id));
        //request.setAttribute("product_review", ProductService.getInstance().getReviewByProductId(product_id));
        request.getRequestDispatcher("./product_detail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
