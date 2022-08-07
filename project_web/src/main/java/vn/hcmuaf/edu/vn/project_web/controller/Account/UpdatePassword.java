package vn.hcmuaf.edu.vn.project_web.controller.Account;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.UserAdminService;
import vn.hcmuaf.edu.vn.project_web.Service.MainService.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdatePassword", value = "/UpdatePassword")
public class UpdatePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id_update");
        String password = request.getParameter("user_password_update");
        String new_password = request.getParameter("user_newpassword_update");
        String confirm_newpassword = request.getParameter("user_confirmpassword_update");
        HttpSession session = request.getSession();
        String db_password = (String) session.getAttribute("password");
        if(UserService.getInstance().CheckOldPassword(password,db_password)){
            if (UserService.getInstance().updateUserPassword(user_id,new_password,confirm_newpassword))
            {
                request.getRequestDispatcher("./AccountPage").forward(request,response);
            }
            request.setAttribute("error_pass","something is wrong");
            request.getRequestDispatcher("./AccountPage").forward(request,response);
            System.out.println("Wrong in servlet");
        }
        else {
            request.setAttribute("error_pass","please check your password");
            request.getRequestDispatcher("./AccountPage").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
