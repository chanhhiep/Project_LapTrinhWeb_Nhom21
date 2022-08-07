package vn.hcmuaf.edu.vn.project_web.controller.Checkout;

import vn.hcmuaf.edu.vn.project_web.Dao.MainDao.CheckoutDao;
import vn.hcmuaf.edu.vn.project_web.Service.MainService.CheckoutService;
import vn.hcmuaf.edu.vn.project_web.Service.MainService.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckoutPage", value = "/CheckoutPage")
public class CheckoutPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("payment_method", CheckoutService.getInstance().GetPaymentMethods());
        request.getRequestDispatcher("./payment.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
