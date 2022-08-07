package vn.hcmuaf.edu.vn.project_web.Service.MainService;

import vn.hcmuaf.edu.vn.project_web.Dao.MainDao.ProductDao;
import vn.hcmuaf.edu.vn.project_web.beans.Category;
import vn.hcmuaf.edu.vn.project_web.beans.Color;
import vn.hcmuaf.edu.vn.project_web.beans.Product;
import vn.hcmuaf.edu.vn.project_web.beans.Size;

import java.util.List;

public class ProductService {
    private static ProductService instance = null;
    private ProductService(){

    }
    public static ProductService getInstance() {
        if(instance==null){
            instance= new ProductService();
        }
        return instance;
    }
    public List<Product> GetAllProducts(){
        return ProductDao.getInstance().GetAllProducts();
    }
    public List<Product> GetAllProductsByCategoryId(String category_id){
        return ProductDao.getInstance().GetProductByCategory(category_id);
    }
    public Product GetProductById(String product_id){
        return ProductDao.getInstance().GetProductsByID(product_id);
    }
    public List<Size> GetAllSize(){
        return  ProductDao.getInstance().getAllSize();
    }
    public List<Color> getAllColor(){
        return ProductDao.getInstance().getAllColor();
    }
    public List<Product> GetProductBySizeId(String size_id){
        return ProductDao.getInstance().GetProductBySizeId(size_id);
    }
    public List<Product> GetProductByColorId(String color_id){
        return ProductDao.getInstance().GetProductByColorId(color_id);
    }
    public List<Product> GetProductByPriceRange(double min_price, double max_price){
        return ProductDao.getInstance().getProductByRangePrice(min_price, max_price);
    }
    public List<Category> GetAllCategory(){
        return ProductDao.getInstance().getAllCategory();
    }
}
