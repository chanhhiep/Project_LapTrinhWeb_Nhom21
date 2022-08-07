package vn.hcmuaf.edu.vn.project_web.controller.ProductList;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductByPriceRange", value = "/ProductByPriceRange")
public class ProductByPriceRange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double min_price = Double.parseDouble(request.getParameter("min_price"));
        double max_price = Double.parseDouble(request.getParameter("max_price"));
        request.setAttribute("products", ProductService.getInstance().GetProductByPriceRange(min_price,max_price));
        request.setAttribute("sizes",ProductService.getInstance().GetAllSize());
        request.setAttribute("colors",ProductService.getInstance().getAllColor());
        request.getRequestDispatcher("./product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
