package vn.hcmuaf.edu.vn.project_web.controller.Account;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.UserService;
import vn.hcmuaf.edu.vn.project_web.beans.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@WebServlet(name = "AccountPage", value = "/AccountPage")
public class AccountPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String customer_id = (String) session.getAttribute("customer");
        Customer customer=UserService.getInstance().getCustomerById(customer_id);
        if (UserService.getInstance().getCustomerById(customer_id) != null)
        {
            session.setAttribute("cus",customer);
        }
        else
        {
            response.sendRedirect("./Login.jsp");
        }
        request.getRequestDispatcher("/account.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request, response);
    }
}
