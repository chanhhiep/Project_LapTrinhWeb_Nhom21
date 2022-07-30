package vn.hcmuaf.edu.vn.project_web.Service.AdminService;

import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.ProductDao;
import vn.hcmuaf.edu.vn.project_web.beans.Product;

import java.util.List;

public class ProductAdminService {
    private static ProductAdminService instance;

    public static ProductAdminService getInstance(){
        if(instance==null){
            instance=new ProductAdminService();
        }
        return instance;
    }
    private ProductAdminService(){

    }
    public List<Product> getAllProduct(){
        System.out.println("da return value 1");
        // return new LinkedList<>(productMap.values());
        return ProductDao.getInstance().getAllProduct();
    }

    public Product getByID(String id) {
        return ProductDao.getInstance().getProductById(id);
    }
}
