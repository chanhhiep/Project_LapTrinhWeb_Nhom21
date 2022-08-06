package vn.hcmuaf.edu.vn.project_web.controller.Admin.promotion;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.PromotionAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdatePromotionController", value = "/UpdatePromotionController")
public class UpdatePromotionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String promotion_id = request.getParameter("promotion_id_update");
        String promotion_name = request.getParameter("promotion_name_update");
        double promotion_rate = Double.parseDouble(request.getParameter("promotion_rate_update"));
        String promotion_content = request.getParameter("promotion_content_update");
        int active = Integer.parseInt(request.getParameter("promotion_active_update"));
        if(PromotionAdminService.getInstance().UpdatePromotionById(promotion_id,promotion_name,promotion_rate,promotion_content,active)){
            response.sendRedirect("./PromotionAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./PromotionAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
