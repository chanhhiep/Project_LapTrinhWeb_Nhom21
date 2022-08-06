package vn.hcmuaf.edu.vn.project_web.controller.Admin.payment;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.PaymentAdminService;
import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ProductAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdatePaymentController", value = "/UpdatePaymentController")
public class UpdatePaymentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String payment_id = request.getParameter("payment_id_update");
        String payment_name = request.getParameter("payment_name_update");
        if(PaymentAdminService.getInstance().UpdatePaymentById(payment_id,payment_name)){
            response.sendRedirect("./PaymentAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./PaymentAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
