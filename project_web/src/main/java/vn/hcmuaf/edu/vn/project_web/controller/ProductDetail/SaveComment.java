package vn.hcmuaf.edu.vn.project_web.controller.ProductDetail;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.ProductService;
import vn.hcmuaf.edu.vn.project_web.beans.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveComment", value = "/SaveComment")
public class SaveComment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("auth");
        if(user == null){
            response.sendRedirect("./LoginPage");
        }
        else {
            String product_id = request.getParameter("product_id");
            String username = user.getUsername();
            int start_number =5;
            String content = request.getParameter("content");
            if(ProductService.getInstance().SaveReview(product_id,username,start_number,content)){
                response.sendRedirect("./ProductDetailController");
            }
            else {
                response.sendRedirect("./ProductDetailController");
            }
        }
    }
}
