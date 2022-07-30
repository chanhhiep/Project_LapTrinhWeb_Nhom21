package vn.hcmuaf.edu.vn.project_web.Dao.AdminDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDao {
    private static ProductDao instance=null;
    public ProductDao(){
        //do nothing
    }
    public static ProductDao getInstance(){
        if(instance==null){
            instance=new ProductDao();
        }
        return instance;
    }
    public List<Product> getAllProduct(){
        List<Product> result = new ArrayList<Product>();
        String sql  = "select a.product_id,a.product_name,a.category_id,a.price,b.promotion_rate,a.promotion_id,d.color_id" +
                ",d.size_id,a.brand,c.category_name,a.inventoryquantity,a.description,a.active,a.create_date,a.update_date " +
                "FROM product a JOIN promotion b on a.id_km=b.id_km " +
                "JOIN productdetail d on a.product_id=d.product_id " +
                "JOIN category c on a.category_id=c.category_id";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Product(rs.getString("product_id"), rs.getString("product_name")
                        ,rs.getString("category_id"),rs.getDouble("price")
                        ,rs.getDouble("promotion_rate"),rs.getString("promotion_id")
                        ,rs.getString("color_id"),rs.getString("size_id")
                        ,rs.getString("brand"),rs.getString("category_name")
                        ,rs.getInt("inventoryquantity"),rs.getString("description")
                        ,rs.getInt("active")));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public Product getProductById(String product_id){
        List<Product> result = new ArrayList<Product>();
        String sql  = "select a.product_id,a.product_name,a.category_id,a.price,b.promotion_rate,a.promotion_id,d.color_id" +
                ",d.size_id,a.brand,c.category_name,a.inventoryquantity,a.description,a.active,a.create_date,a.update_date " +
                "FROM product a JOIN promotion b on a.id_km=b.id_km " +
                "JOIN productdetail d on a.product_id=d.product_id " +
                "JOIN category c on a.category_id=c.category_id" +
                "where a.product_id= ?";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,product_id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Product(rs.getString("product_id"), rs.getString("product_name")
                        ,rs.getString("category_id"),rs.getDouble("price")
                        ,rs.getDouble("promotion_rate"),rs.getString("promotion_id")
                        ,rs.getString("color_id"),rs.getString("size_id")
                        ,rs.getString("brand"),rs.getString("category_name")
                        ,rs.getInt("inventoryquantity"),rs.getString("description")
                        ,rs.getInt("active")));
            }
            System.out.println("et o et");
            rs.close();
            System.out.println(result.get(0));
            if(result.size()!=1)return null;
            Product pro = result.get(0);
            System.out.println("success prepare");
            if(!pro.getProduct_id().equals(product_id)) return null;
            System.out.println("success");
            return pro;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result.get(0);
    }
    public boolean SaveProduct(String product_id, String product_name, String category_id, double price, String promotion_id, String brand, String inventory_quantity, String description){
        int active = 1;
        LocalDateTime createDate = LocalDateTime.now();
        LocalDateTime updateDate = LocalDateTime.now();
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into product(product_id,product_name,product_category,price,promotion_id,brand,inventory_quantity,description,active,createDate,updateDate ) values(?,?,?,?,?,?,?,?,?,?,?)")
                        .bind(0,product_id)
                        .bind(1,product_name)
                        .bind(2,category_id)
                        .bind(3,price)
                        .bind(4,promotion_id)
                        .bind(5,brand)
                        .bind(6,inventory_quantity)
                        .bind(7,description)
                        .bind(8,active)
                        .bind(9,createDate)
                        .bind(10,updateDate)
                        .execute()
        );
        return i==1;
    }
}
