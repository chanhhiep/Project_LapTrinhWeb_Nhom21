package vn.hcmuaf.edu.vn.project_web.controller.Admin.receipt;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ProductAdminService;
import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ReceiptAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteReceiptController", value = "/DeleteReceiptController")
public class DeleteReceiptController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String receipt_id = request.getParameter("receipt_id_delete");
        if(ReceiptAdminService.getInstance().DeleteReceiptById(receipt_id)){
            response.sendRedirect("./ReceiptAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./ReceiptAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
