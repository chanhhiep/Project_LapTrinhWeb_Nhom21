package vn.hcmuaf.edu.vn.project_web.Dao.AdminDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.Product;

import java.sql.*;
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
        String sql  = "select a.product_id,a.product_name,a.category_id,a.price,b.promotion_rate,a.promotion_id" +
                ",a.brand,c.category_name,a.inventoryquantity,a.description,a.active,a.create_date,a.update_date " +
                "FROM promotion b JOIN product a  on b.promotion_id=a.promotion_id " +
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
        String sql  = "select a.product_id,a.product_name,a.category_id,a.price,b.promotion_rate,a.promotion_id" +
                ",a.brand,c.category_name,a.inventoryquantity,a.description,a.active,a.create_date,a.update_date " +
                "FROM promotion b JOIN product a  on b.promotion_id=a.promotion_id " +
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
    public boolean SaveProduct(String product_id, String product_name, String category_id, double price, String promotion_id, String brand, int inventory_quantity, String description){
        int active = 1;
        Timestamp createDate = new Timestamp(new Date().getTime());
        Timestamp updateDate = new Timestamp(new Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into product(product_id,product_name,category_id,price,promotion_id,brand,inventoryquantity,description,active,create_date,update_date ) values(?,?,?,?,?,?,?,?,?,?,?)")
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
    public static boolean UpdateProductById(String product_id, String product_name, String category_id, double price, String promotion_id, String brand, int inventory_quantity, String description,int active){
        Timestamp updateDate = new Timestamp(new Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("update product " +
                                "set product_name=?,category_id=?,price=?,promotion_id=?,brand=?,inventoryquantity=?,description=?,active=?,update_date=? " +
                                "where product_id=?")
                        .bind(0,product_name)
                        .bind(1,category_id)
                        .bind(2,price)
                        .bind(3,promotion_id)
                        .bind(4,brand)
                        .bind(5,inventory_quantity)
                        .bind(6,description)
                        .bind(7,active)
                        .bind(8,updateDate)
                        .bind(9,product_id)
                        .execute()
        );
        return i==1;

    }
    public boolean DeleteProductById(String product_id){
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("delete from product where product_id = ?")
                        .bind(0,product_id)
                        .execute()
        );
        return i==1;
    }
}
