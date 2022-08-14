package vn.hcmuaf.edu.vn.project_web.controller.Admin.promotion;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.CategoryAdminService;
import vn.hcmuaf.edu.vn.project_web.Service.AdminService.PromotionAdminService;
import vn.hcmuaf.edu.vn.project_web.beans.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PromotionAdminController", value = "/PromotionAdminController")
public class PromotionAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User admin = (User) session.getAttribute("admin_auth");
        if(admin == null){
            response.sendRedirect("./LoginAdminController");
        }
        else {
            request.setAttribute("promotions_admin", PromotionAdminService.getInstance().getAllPromotion());
            request.getRequestDispatcher("/admin/admin_promotion.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
