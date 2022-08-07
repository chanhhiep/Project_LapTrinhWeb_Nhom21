package vn.hcmuaf.edu.vn.project_web.controller.Admin.receipt;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ProductAdminService;
import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ReceiptAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveReceiptController", value = "/SaveReceiptController")
public class SaveReceiptController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String receipt_id = request.getParameter("receipt_id");
        String customer_id = request.getParameter("customer_id");
        String discountcode_id= request.getParameter("discountcode_id");
        String payment_id = request.getParameter("payment_id");
        Double value = Double.parseDouble(request.getParameter("value"));
        if(ReceiptAdminService.getInstance().SaveReceipt(receipt_id,customer_id,discountcode_id,payment_id,value)){
            response.sendRedirect("./ReceiptAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./ReceiptAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
