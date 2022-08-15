package vn.hcmuaf.edu.vn.project_web.controller.Admin.image;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.ImageAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteImageController", value = "/DeleteImageController")
public class DeleteImageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Image_id = request.getParameter("image_id_delete");
        if(ImageAdminService.getInstance().DeleteImageById(Image_id)){
            response.sendRedirect("./ImageAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./ImageAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
