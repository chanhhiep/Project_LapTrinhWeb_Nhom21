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
        for(Product p:ProductDao.getInstance().getAllProduct()){
            System.out.println(p.toString());
        }
        return ProductDao.getInstance().getAllProduct();
    }

    public Product getByID(String id) {
        return ProductDao.getInstance().getProductById(id);
    }
    public boolean SaveProduct(String product_id, String product_name, String category_id, double price, String promotion_id, String brand, int inventory_quantity, String description){
        return ProductDao.getInstance().SaveProduct(product_id, product_name, category_id, price, promotion_id, brand, inventory_quantity, description);
    }
    public boolean UpdateProductById(String product_id, String product_name, String category_id, double price, String promotion_id, String brand, int inventory_quantity, String description,int active){
        return ProductDao.UpdateProductById(product_id, product_name, category_id, price, promotion_id, brand, inventory_quantity, description, active);
    }
    public boolean DeleteProductById(String product_id){
        return ProductDao.getInstance().DeleteProductById(product_id);
    }
}
