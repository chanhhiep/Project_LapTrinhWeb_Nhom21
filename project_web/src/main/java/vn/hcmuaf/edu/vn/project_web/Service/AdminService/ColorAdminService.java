package vn.hcmuaf.edu.vn.project_web.Service.AdminService;

import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.ColorDao;
import vn.hcmuaf.edu.vn.project_web.beans.Color;

import java.util.List;

public class ColorAdminService {
    private static ColorAdminService instance;

    public static ColorAdminService getInstance(){
        if(instance==null){
            instance=new ColorAdminService();
        }
        return instance;
    }
    private ColorAdminService(){

    }
    public List<Color> getAllColor(){

        for(Color p: ColorDao.getInstance().getAllColor()){
            System.out.println(p.toString());
        }
        return ColorDao.getInstance().getAllColor();
    }

    public boolean SaveColor(String color_id,String color_name){
        return ColorDao.getInstance().SaveColor(color_id,color_name);
    }
    public boolean UpdateColorById(String color_id,String color_name){
        return ColorDao.getInstance().UpdateColorById(color_id,color_name);
    }
    public boolean DeleteColorById(String color_id){
        return ColorDao.getInstance().DeleteColorById(color_id);
    }
}
