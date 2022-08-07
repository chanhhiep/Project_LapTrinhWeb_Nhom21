package vn.hcmuaf.edu.vn.project_web.controller.ProductList;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductByColor", value = "/ProductByColor")
public class ProductByColor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color_id = request.getParameter("color_id");
        request.setAttribute("products", ProductService.getInstance().GetProductByColorId(color_id));
        request.setAttribute("sizes",ProductService.getInstance().GetAllSize());
        request.setAttribute("colors",ProductService.getInstance().getAllColor());
        request.getRequestDispatcher("./product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
