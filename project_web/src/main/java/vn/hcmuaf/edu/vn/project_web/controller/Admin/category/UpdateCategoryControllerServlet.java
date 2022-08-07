package vn.hcmuaf.edu.vn.project_web.controller.Admin.category;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.CategoryAdminService;
import vn.hcmuaf.edu.vn.project_web.Service.AdminService.PaymentAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCategoryControllerServlet", value = "/UpdateCategoryController")
public class UpdateCategoryControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category_id = request.getParameter("category_id_update");
        String category_name = request.getParameter("category_name_update");
        if(CategoryAdminService.getInstance().UpdateCategoryById(category_id,category_name)){
            response.sendRedirect("./CategoryAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./CategoryAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
