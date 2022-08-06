package vn.hcmuaf.edu.vn.project_web.controller.Admin.customer;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.CustomerAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveCustomerController", value = "/SaveCustomerController")
public class SaveCustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customer_id = request.getParameter("customer_id");
        String customer_name = request.getParameter("customer_name");
        String email = request.getParameter("customer_email");
        String phone = request.getParameter("customer_phone");
        String address = request.getParameter("customer_address");
        if(CustomerAdminService.getInstance().SaveCustomer(customer_id,customer_name,email,phone,address)){
            response.sendRedirect("./CustomerAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./CustomerAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
