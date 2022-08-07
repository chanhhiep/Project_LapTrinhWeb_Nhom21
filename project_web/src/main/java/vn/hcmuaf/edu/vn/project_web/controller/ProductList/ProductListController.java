package vn.hcmuaf.edu.vn.project_web.controller.ProductList;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductListController", value = "/ProductListController")
public class ProductListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", ProductService.getInstance().GetAllProducts());
        request.setAttribute("sizes",ProductService.getInstance().GetAllSize());
        request.setAttribute("colors",ProductService.getInstance().getAllColor());
        request.getRequestDispatcher("./product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
