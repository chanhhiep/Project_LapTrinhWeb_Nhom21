package vn.hcmuaf.edu.vn.project_web.controller.Admin.payment;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.PaymentAdminService;
import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ProductAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeletePaymentController", value = "/DeletePaymentController")
public class DeletePaymentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String payment_id = request.getParameter("payment_id_delete");
        if(PaymentAdminService.getInstance().DeletePaymentById(payment_id)){
            response.sendRedirect("./PaymentAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./PaymentAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
