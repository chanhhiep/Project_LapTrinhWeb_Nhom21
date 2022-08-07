package vn.hcmuaf.edu.vn.project_web.controller.Admin.promotion;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.PromotionAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SavePromotionController", value = "/SavePromotionController")
public class SavePromotionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String promotion_id = request.getParameter("promotion_id");
        String promotion_name = request.getParameter("promotion_name");
        double promotion_rate = Double.parseDouble(request.getParameter("promotion_rate"));
        String promotion_content = request.getParameter("promotion_content");
        if(PromotionAdminService.getInstance().SavePromotion(promotion_id,promotion_name,promotion_rate,promotion_content)){
            response.sendRedirect("./PromotionAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher(".PromotionAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
