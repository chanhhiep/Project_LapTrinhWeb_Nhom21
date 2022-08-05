package vn.hcmuaf.edu.vn.project_web.Service.AdminService;

import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.SizeDao;
import vn.hcmuaf.edu.vn.project_web.beans.Size;

import java.util.List;

public class SizeAdminService {
    private static SizeAdminService instance;

    public static SizeAdminService getInstance(){
        if(instance==null){
            instance=new SizeAdminService();
        }
        return instance;
    }
    private SizeAdminService(){

    }
    public List<Size> getAllSize(){

        for(Size p: SizeDao.getInstance().getAllSize()){
            System.out.println(p.toString());
        }
        return SizeDao.getInstance().getAllSize();
    }

    public boolean SaveSize(String Size_id,String Size_name){
        return SizeDao.getInstance().SaveSize(Size_id,Size_name);
    }
    public boolean UpdateSizeById(String Size_id,String Size_name){
        return SizeDao.getInstance().UpdateSizeById(Size_id,Size_name);
    }
    public boolean DeleteSizeById(String Size_id){
        return SizeDao.getInstance().DeleteSizeById(Size_id);
    }
}
