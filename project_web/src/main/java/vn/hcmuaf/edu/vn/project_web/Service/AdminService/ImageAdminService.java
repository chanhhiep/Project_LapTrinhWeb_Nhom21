package vn.hcmuaf.edu.vn.project_web.Service.AdminService;

import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.ImageDao;
import vn.hcmuaf.edu.vn.project_web.beans.Image;

import java.util.List;

public class ImageAdminService {
    private static ImageAdminService instance;

    public static ImageAdminService getInstance(){
        if(instance==null){
            instance=new ImageAdminService();
        }
        return instance;
    }
    private ImageAdminService(){

    }
    public List<Image> getAllImage(){

        for(Image p: ImageDao.getInstance().getAllImage()){
            System.out.println(p.toString());
        }
        return ImageDao.getInstance().getAllImage();
    }

    public boolean SaveImage(String Image_id,String Image_name){
        return ImageDao.getInstance().SaveImage(Image_id,Image_name);
    }
    public boolean UpdateImageById(String Image_id,String Image_name){
        return ImageDao.getInstance().UpdateImageById(Image_id,Image_name);
    }
    public boolean DeleteImageById(String Image_id){
        return ImageDao.getInstance().DeleteImageById(Image_id);
    }
}
