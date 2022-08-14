package vn.hcmuaf.edu.vn.project_web.controller.Admin.payment;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.PaymentAdminService;
import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ProductAdminService;
import vn.hcmuaf.edu.vn.project_web.beans.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PaymentAdminController", value = "/PaymentAdminController")
public class PaymentAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User admin = (User) session.getAttribute("admin_auth");
        if(admin == null){
            response.sendRedirect("./LoginAdminController");
        }
        else {
            request.setAttribute("payments_admin", PaymentAdminService.getInstance().getAllPayment());
            request.getRequestDispatcher("/admin/admin_payment.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
