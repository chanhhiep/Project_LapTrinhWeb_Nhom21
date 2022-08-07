package vn.hcmuaf.edu.vn.project_web.controller.Cart;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.CartService;
import vn.hcmuaf.edu.vn.project_web.beans.CartItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteCartController", value = "/DeleteCartController")
public class DeleteCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String product_id = request.getParameter("product_id");
        int index = CartService.getInstance().isExits(product_id,request);
        List<CartItem> carts = (List<CartItem>)session.getAttribute("cart");
        carts.remove(index);
        session.setAttribute("cart",carts);
        System.out.println("delete success");
        response.sendRedirect("./ShowCartController");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
