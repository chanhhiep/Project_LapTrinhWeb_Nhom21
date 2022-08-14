package vn.hcmuaf.edu.vn.project_web.controller.Checkout;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.CheckoutService;
import vn.hcmuaf.edu.vn.project_web.beans.Coupon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckCoupon", value = "/CheckCoupon")
public class CheckCoupon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String voucher = request.getParameter("voucher");
        HttpSession session = request.getSession();
        Coupon coupons = CheckoutService.getInstance().getCoupon(voucher);
        if (coupons != null)
        {
            session.setAttribute("coupon_rate",coupons.getRate());
            session.setAttribute("coupon_id",coupons.getCoupon_id());
            request.setAttribute("coupon_notify","success apply coupon"+coupons.getContent());
        }
        else
        {
            request.setAttribute("coupon_notify","coupon does exit");
        }
        request.getRequestDispatcher("./CheckoutPage").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
