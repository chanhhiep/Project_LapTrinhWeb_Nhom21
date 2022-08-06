package vn.hcmuaf.edu.vn.project_web.controller.Account;

import vn.hcmuaf.edu.vn.project_web.Dao.MainDao.UserDao;
import vn.hcmuaf.edu.vn.project_web.Service.AdminService.CustomerAdminService;
import vn.hcmuaf.edu.vn.project_web.Service.MainService.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCustomer", value = "/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customer_id = request.getParameter("customer_id_update");
        String customer_name = request.getParameter("customer_name_update");
        String email = request.getParameter("customer_email_update");
        String phone = request.getParameter("customer_phone_update");
        String address = request.getParameter("customer_address_update");
        if(UserService.getInstance().updateCustomer(customer_id,customer_name,email,phone,address)){
            response.sendRedirect("./AccountPage");
        }
        else {
            request.setAttribute("error_user","something is wrong");
            request.getRequestDispatcher("./AccountPage").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
