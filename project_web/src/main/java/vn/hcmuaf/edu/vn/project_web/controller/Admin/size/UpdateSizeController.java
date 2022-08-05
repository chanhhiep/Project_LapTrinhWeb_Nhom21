package vn.hcmuaf.edu.vn.project_web.controller.Admin.size;

import vn.hcmuaf.edu.vn.project_web.Service.AdminService.SizeAdminService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateSizeController", value = "/UpdateSizeController")
public class UpdateSizeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String size_id = request.getParameter("size_id_update");
        String size_name = request.getParameter("size_name_update");
        if(SizeAdminService.getInstance().UpdateSizeById(size_id,size_name)){
            response.sendRedirect("./SizeAdminController");
        }
        else {
            request.setAttribute("error","something is wrong");
            request.getRequestDispatcher("./SizeAdminController").forward(request,response);
            System.out.println("Wrong in servlet");
        }
    }
}
