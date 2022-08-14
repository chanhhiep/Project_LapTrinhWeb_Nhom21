package vn.hcmuaf.edu.vn.project_web.Service.MainService;

import vn.hcmuaf.edu.vn.project_web.Dao.MainDao.ProductDao;
import vn.hcmuaf.edu.vn.project_web.beans.*;

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
    public List<Review> getReviewByProductId(String product_id){
        return ProductDao.getInstance().GetReviewByProductId(product_id);
    };
    public boolean SaveReview(String product_id,String username,int star_number, String content){
        return  ProductDao.getInstance().SaveReview(product_id, username, star_number, content);
    }
}
