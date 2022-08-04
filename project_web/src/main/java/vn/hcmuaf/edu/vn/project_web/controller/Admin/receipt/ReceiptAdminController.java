package vn.hcmuaf.edu.vn.project_web.controller.Admin.receipt;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ProductAdminService;
import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ReceiptAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReceiptAdminController", value = "/ReceiptAdminController")
public class ReceiptAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("receipts_admin", ReceiptAdminService.getInstance().getAllReceipt());
        request.getRequestDispatcher("/admin/admin_receipt.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
