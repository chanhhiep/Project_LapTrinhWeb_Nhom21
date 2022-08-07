package vn.hcmuaf.edu.vn.project_web.controller.Admin.customer;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.CustomerAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCustomerController", value = "/DeleteCustomerController")
public class DeleteCustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customer_id = request.getParameter("customer_id_delete");
        if(CustomerAdminService.getInstance().DeleteCustomerById(customer_id)){
            response.sendRedirect("./CustomerAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./CustomerAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
