package vn.hcmuaf.edu.vn.project_web.controller.Admin.promotion;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.PromotionAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeletePromotionController", value = "/DeletePromotionController")
public class DeletePromotionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String promotion_id = request.getParameter("promotion_id_delete");
        if(PromotionAdminService.getInstance().DeletePromotionById(promotion_id)){
            response.sendRedirect("./PromotionAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./PromotionAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
