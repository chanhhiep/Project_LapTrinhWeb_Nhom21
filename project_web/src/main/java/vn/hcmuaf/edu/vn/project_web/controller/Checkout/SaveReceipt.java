package vn.hcmuaf.edu.vn.project_web.controller.Checkout;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.CheckoutService;
import vn.hcmuaf.edu.vn.project_web.beans.CartItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SaveReceipt", value = "/SaveReceipt")
public class SaveReceipt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customer_name = request.getParameter("customer_name");
        String customer_email = request.getParameter("customer_email");
        String customer_phone = request.getParameter("customer_phone");
        String customer_address = request.getParameter("customer_address");
        String payment_id = request.getParameter("paymentMt");
        double total_money = Double.parseDouble(request.getParameter("total_money"));
        HttpSession session = request.getSession();
        String coupon_id;
        if(session.getAttribute("coupon_id") == null){
            coupon_id = "d00";
        }
        else{
            coupon_id = (String) session.getAttribute("coupon_id");
        }
        //

        //
        List<CartItem> carts = (List<CartItem>) session.getAttribute("cart");
        String customer = (String) session.getAttribute("customer");
        if(session.getAttribute("customer")==null){
            if(customer_name==""||customer_address==""||customer_email==""||customer_address==""){
                request.setAttribute("payment_notify","please fill form");
                request.getRequestDispatcher("./CheckoutPage").forward(request, response);
            }
            else {
                if(CheckoutService.getInstance().SaveReceiptNotLogin(coupon_id,payment_id,total_money,customer_name,customer_address,customer_phone,customer_email,carts)){
                    request.setAttribute("payment_notify","success payment");
                    carts.clear();
                    session.setAttribute("message","payment");
                    request.getRequestDispatcher("./HomePage").forward(request, response);
                }
                else{
                    request.setAttribute("payment_notify","something wrong");
                    request.getRequestDispatcher("./CheckoutPage").forward(request, response);
                }
            }
        }
        else {
            if(CheckoutService.getInstance().SaveReceiptLogin(coupon_id,payment_id,total_money,customer,carts)){
                request.setAttribute("payment_notify","success payment");
                carts.clear();
                session.setAttribute("message","payment");
                request.getRequestDispatcher("./HomePage").forward(request, response);
            }
            else{
                request.setAttribute("payment_notify","something wrong");
                //session.setAttribute("message","false");
                request.getRequestDispatcher("./CheckoutPage").forward(request, response);
            }
        }
    }
}
