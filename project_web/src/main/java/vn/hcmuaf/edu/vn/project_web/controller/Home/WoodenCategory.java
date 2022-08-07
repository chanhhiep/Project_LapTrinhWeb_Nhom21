package vn.hcmuaf.edu.vn.project_web.controller.Home;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WoodenCategory", value = "/WoodenCategory")
public class WoodenCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category_id="cate04";
        request.setAttribute("products", ProductService.getInstance().GetAllProductsByCategoryId(category_id));
        request.getRequestDispatcher("./home.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
