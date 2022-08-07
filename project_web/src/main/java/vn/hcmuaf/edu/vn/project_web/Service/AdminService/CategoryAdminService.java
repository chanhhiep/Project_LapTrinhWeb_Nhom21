package vn.hcmuaf.edu.vn.project_web.Service.AdminService;

import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.CategoryDao;
import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.PaymentDao;
import vn.hcmuaf.edu.vn.project_web.beans.Category;

import java.util.List;

public class CategoryAdminService {
    private static CategoryAdminService instance;

    public static CategoryAdminService getInstance(){
        if(instance==null){
            instance=new CategoryAdminService();
        }
        return instance;
    }
    private CategoryAdminService(){

    }
    public List<Category> getAllCategory(){

        for(Category p: CategoryDao.getInstance().getAllCategoryDao()){
            System.out.println(p.toString());
        }
        return CategoryDao.getInstance().getAllCategoryDao();
    }

    public boolean SaveCategory(String category_id,String category_name){
        return CategoryDao.getInstance().SaveCategory(category_id,category_name);
    }
    public boolean UpdateCategoryById(String category_id,String category_name){
        return CategoryDao.getInstance().UpdateCategoryById(category_id,category_name);
    }
    public boolean DeleteCategoryById(String category_id){
        return CategoryDao.getInstance().DeleteCategoryById(category_id);
    }
}
