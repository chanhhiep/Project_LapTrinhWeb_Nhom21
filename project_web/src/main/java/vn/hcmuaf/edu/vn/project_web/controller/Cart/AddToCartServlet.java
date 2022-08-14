package vn.hcmuaf.edu.vn.project_web.controller.Cart;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.CartService;
import vn.hcmuaf.edu.vn.project_web.Service.MainService.ProductService;
import vn.hcmuaf.edu.vn.project_web.beans.CartItem;
import vn.hcmuaf.edu.vn.project_web.beans.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_id = request.getParameter("product_id");
        Product product = ProductService.getInstance().GetProductById(product_id);
        HttpSession session = request.getSession();

        if (session.getAttribute("cart") == null)
        {
            List<CartItem> carts = new ArrayList<CartItem>();
            carts.add(new CartItem(product_id,product));
            session.setAttribute("cart",carts);


        }
        else
        {
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            if (CartService.getInstance().isExits(product_id,request) == -1)
            {
                cart.add(new CartItem(product_id,product));
            }
            else
            {
                cart.get(CartService.getInstance().isExits(product_id,request)).getCart_product().quantitySold +=1;
            }
            System.out.println("herehrehre");
            session.setAttribute("cart",cart);
        }
        session.setAttribute("message","added");
        response.sendRedirect("./HomePage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
