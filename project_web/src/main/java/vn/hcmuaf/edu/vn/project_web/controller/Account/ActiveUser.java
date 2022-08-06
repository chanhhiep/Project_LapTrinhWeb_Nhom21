package vn.hcmuaf.edu.vn.project_web.controller.Account;

import vn.hcmuaf.edu.vn.project_web.Dao.MainDao.UserDao;
import vn.hcmuaf.edu.vn.project_web.Service.MainService.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ActiveUser", value = "/ActiveUser")
public class ActiveUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        if (UserDao.getInstance().activeUser(token))
        {
            RequestDispatcher dd = request.getRequestDispatcher("/LoginPage");
            dd.forward(request, response);
            response.sendRedirect("./LoginPage");
        }
        RequestDispatcher aa = request.getRequestDispatcher("/LoginPage");
        aa.forward(request, response);
        response.sendRedirect("./RegisterPage");
    }
}
