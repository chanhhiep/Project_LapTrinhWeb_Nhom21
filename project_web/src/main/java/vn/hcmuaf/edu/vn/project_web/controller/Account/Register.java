package vn.hcmuaf.edu.vn.project_web.controller.Account;

import vn.hcmuaf.edu.vn.project_web.Service.MainService.UserService;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * if (doRegister(username, password, confirmPassword, email, ten_kh, diachi, sodt))
            {
                ViewBag.Message = username + "sucess register";
                //Session["email"] = email;
                sendMail(email);
                return RedirectToAction("Login");
            }
            else
            {
                ViewBag.Message = "username is exist in system";
                return View();
            }*/
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String confirm = request.getParameter("confirm");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        if (UserService.getInstance().Register(username, password, name, confirm, email, phone, address)) {
            UserService.getInstance().sendMail(email);
            response.sendRedirect("./LoginPage");
        } else {
            request.setAttribute("error", "username is exits or error system");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            System.out.println("Wrong in servlet");
            System.out.println(username + "  " + password);
        }
    }
}
