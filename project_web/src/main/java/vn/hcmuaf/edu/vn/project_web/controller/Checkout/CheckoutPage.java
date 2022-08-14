package vn.hcmuaf.edu.vn.project_web.controller.Checkout;

import vn.hcmuaf.edu.vn.project_web.Dao.MainDao.CheckoutDao;
import vn.hcmuaf.edu.vn.project_web.Service.MainService.CheckoutService;
import vn.hcmuaf.edu.vn.project_web.Service.MainService.ProductService;
import vn.hcmuaf.edu.vn.project_web.beans.CartItem;
import vn.hcmuaf.edu.vn.project_web.beans.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CheckoutPage", value = "/CheckoutPage")
public class CheckoutPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("payments_method", CheckoutService.getInstance().GetPaymentMethods());
        String customer_id = (String) session.getAttribute("customer");
        Customer customer = null;
        if(customer_id != null){
            customer = CheckoutService.getInstance().getCustomerById(customer_id);
        }
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null)
        {
            cart = new ArrayList<CartItem>();
        }
        session.setAttribute("cart",cart);
        request.setAttribute("carts",cart);
        request.setAttribute("customer",customer);
        request.getRequestDispatcher("./payment.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
