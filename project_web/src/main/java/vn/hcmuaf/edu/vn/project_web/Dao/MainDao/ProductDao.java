package vn.hcmuaf.edu.vn.project_web.Dao.MainDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.beans.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public String getImageMain(String product_id)
    {
        String ImgLink="";
        List<String> ImageList = new ArrayList<String>();
        ResultSet rs = null;
        try {
            Connection conn = DBConnect.getInstance().getConn();
            PreparedStatement statement = conn.prepareStatement("select image_link from image i join productdetail p on i.image_id = p.image_id  where product_id = ?");
            statement.setString(1,product_id);
            rs = statement.executeQuery();
            while(rs.next()){
                ImageList.add(rs.getString("image_link"));
            }
            rs.close();
            ImgLink = ImageList.get(0);

            return ImgLink;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<String> getImageById(String product_id)
    {
        List<String> ImageList = new ArrayList<String>();
        ResultSet rs = null;
        try {
            Connection conn = DBConnect.getInstance().getConn();
            PreparedStatement statement = conn.prepareStatement("select image_link from image i join productdetail r on i.image_id = r.image_id  where product_id = ?");
            statement.setString(1,product_id);
            rs = statement.executeQuery();
            while(rs.next()){
                ImageList.add(rs.getString("image_link"));
            }
            rs.close();
            return ImageList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Product GetProductsByID(String product_id)
    {
        List<Product> result = new ArrayList<Product>();
        String sql  = "select a.product_id,a.product_name,a.category_id,a.price,b.promotion_rate,a.promotion_id" +
                ",a.brand,c.category_name,a.inventoryquantity,a.description,a.active,a.create_date,a.update_date " +
                "FROM promotion b JOIN product a  on b.promotion_id=a.promotion_id " +
                "JOIN category c on a.category_id=c.category_id where a.product_id=?";
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
            rs.close();
            System.out.println(result.get(0));
            if(result.size()!=1)return null;
            Product product = result.get(0);
            System.out.println("success prepare");
            if(!product.getProduct_id().equals(product_id)) return null;
            System.out.println("success");
            product.images = getImageById(product_id);
            product.imageMain=getImageMain(product_id);

            return product;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public Product GetProductsByName(String product_name)
    {
        List<Product> result = new ArrayList<Product>();
        String sql  = "select a.product_id,a.product_name,a.category_id,a.price,b.promotion_rate,a.promotion_id" +
                ",a.brand,c.category_name,a.inventoryquantity,a.description,a.active,a.create_date,a.update_date " +
                "FROM promotion b JOIN product a  on b.promotion_id=a.promotion_id " +
                "JOIN category c on a.category_id=c.category_id where a.product_name=?";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,product_name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Product(rs.getString("product_id"), rs.getString("product_name")
                        ,rs.getString("category_id"),rs.getDouble("price")
                        ,rs.getDouble("promotion_rate"),rs.getString("promotion_id")
                        ,rs.getString("brand"),rs.getString("category_name")
                        ,rs.getInt("inventoryquantity"),rs.getString("description")
                        ,rs.getInt("active")));
            }
            rs.close();
            System.out.println(result.get(0));
            if(result.size()!=1)return null;
            Product product = result.get(0);
            System.out.println("success prepare");
            if(!product.getProduct_name().equals(product_name)) return null;
            System.out.println("success");
            return product;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }
    public List<Product> GetProductBySizeId(String size_id){
        List<Product> result = new ArrayList<Product>();
        String sql  = "select a.product_id,a.product_name,a.category_id,a.price,b.promotion_rate,a.promotion_id" +
                ",a.brand,c.category_name,a.inventoryquantity,a.description,a.active,a.create_date,a.update_date " +
                "FROM promotion b JOIN product a  on b.promotion_id=a.promotion_id " +
                "JOIN category c on a.category_id=c.category_id " +
                "JOIN productdetail d on d.product_id = a.product_id where d.size_id=?";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,size_id);
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
            for (Product p: result) {
                p.imageMain=getImageMain(p.product_id);
            }
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }
    public List<Product> GetProductByColorId(String color_id){
        List<Product> result = new ArrayList<Product>();
        String sql  = "select a.product_id,a.product_name,a.category_id,a.price,b.promotion_rate,a.promotion_id" +
                ",a.brand,c.category_name,a.inventoryquantity,a.description,a.active,a.create_date,a.update_date " +
                "FROM promotion b JOIN product a  on b.promotion_id=a.promotion_id " +
                "JOIN category c on a.category_id=c.category_id " +
                "JOIN productdetail d on d.product_id = a.product_id where d.color_id=?";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,color_id);
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
            for (Product p: result) {
                p.imageMain=getImageMain(p.product_id);
            }
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }
    public List<Product> getProductByRangePrice(double min_price, double max_price){
        List<Product> result = new ArrayList<Product>();
        String sql  = "select a.product_id,a.product_name,a.category_id,a.price,b.promotion_rate,a.promotion_id" +
                ",a.brand,c.category_name,a.inventoryquantity,a.description,a.active,a.create_date,a.update_date " +
                "FROM promotion b JOIN product a  on b.promotion_id=a.promotion_id " +
                "JOIN category c on a.category_id=c.category_id where a.price>? and a.price<?";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(1,min_price);
            statement.setDouble(2,max_price);
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
            for (Product p: result) {
                p.imageMain=getImageMain(p.product_id);
            }
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }
    public List<Product> GetAllProducts()
    {
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
            for (Product p: result) {
                p.imageMain=getImageMain(p.product_id);
            }
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public List<String> GetColorsByIDProduct(String product_id)
    {

        List<String> ColorList = new ArrayList<String>();
        ResultSet rs = null;
        try {
            Connection conn = DBConnect.getInstance().getConn();
            PreparedStatement statement = conn.prepareStatement("select color_name from color c join receiptdetail r on c.color_id = r.color_id  where product_id = ?");
            statement.setString(1,product_id);
            rs = statement.executeQuery();
            while(rs.next()){
                ColorList.add("color_name");
            }
            rs.close();


            return ColorList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<String> GetSizesByIDProduct(String product_id)
    {
        List<String> SizeList = new ArrayList<String>();
        ResultSet rs = null;
        try {
            Connection conn = DBConnect.getInstance().getConn();
            PreparedStatement statement = conn.prepareStatement("select size_name from size s join receiptdetail r on s.size_id = r.size_id  where product_id = ?");
            statement.setString(1,product_id);
            rs = statement.executeQuery();
            while(rs.next()){
                SizeList.add("size_name");
            }
            rs.close();

            return SizeList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Product> GetProductByCategory(String category_id){
        List<Product> result = new ArrayList<Product>();
        String sql  = "select a.product_id,a.product_name,a.category_id,a.price,b.promotion_rate,a.promotion_id" +
                ",a.brand,c.category_name,a.inventoryquantity,a.description,a.active,a.create_date,a.update_date " +
                "FROM promotion b JOIN product a  on b.promotion_id=a.promotion_id " +
                "JOIN category c on a.category_id=c.category_id where a.category_id=?";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,category_id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Product(rs.getString("product_id"), rs.getString("product_name")
                        ,rs.getString("category_id"),rs.getDouble("price")
                        ,rs.getDouble("promotion_rate"),rs.getString("promotion_id")
                        ,rs.getString("brand"),rs.getString("category_name")
                        ,rs.getInt("inventoryquantity"),rs.getString("description")
                        ,rs.getInt("active")));
            }
            rs.close();
            for (Product p: result) {
                p.imageMain=getImageMain(p.product_id);
            }
            return result;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public List<Category> getAllCategory(){
        List<Category> result = new ArrayList<Category>();
        String sql  = "select category_id,category_name,create_date,update_date " +
                "FROM category";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Category(rs.getString("category_id"),rs.getString("category_name"),rs.getTimestamp("create_date"),rs.getTimestamp("update_date")));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }
    public List<Size> getAllSize(){
        List<Size> result = new ArrayList<Size>();
        String sql  = "select size_id,size_name,create_date,update_date " +
                "FROM size";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Size(rs.getString("size_id"),rs.getString("size_name"),rs.getTimestamp("create_date"),rs.getTimestamp("update_date")));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public List<Color> getAllColor(){
        List<Color> result = new ArrayList<Color>();
        String sql  = "select color_id,color_name,create_date,update_date " +
                "FROM color";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Color(rs.getString("color_id"),rs.getString("color_name"),rs.getTimestamp("create_date"),rs.getTimestamp("update_date")));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }
    public List<Product> GetRelatedProducts(String category, String loai)
    {
        String queryString = "SELECT a.product_id,a.product_name,a.category_id,a.price,a.loai,a.id_km,a.thuonghieu,a.soluongton,a.mota,a.active from sanpham a, loaisanpham b where a.ma_loaisp = b.ma_loaisp and a.ma_loaisp =@maloaisp and a.loai=@loai order by a.gia limit 4";

        /*MySqlConnection conn = KetNoi.GetDBConnection();
        conn.Open();
        MySqlCommand newCmd = conn.CreateCommand();
        string queryString = "SELECT a.id_sanpham,a.ten_sp,a.ma_loaisp,a.gia,a.loai,a.id_km,a.thuonghieu,a.soluongton,a.mota,a.active from sanpham a, loaisanpham b where a.ma_loaisp = b.ma_loaisp and a.ma_loaisp =@maloaisp and a.loai=@loai order by a.gia limit 4";
        MySqlParameter maloaisp = new MySqlParameter("@maloaisp", MySqlDbType.String);
        maloaisp.Value = cat;
        MySqlParameter loaisp = new MySqlParameter("@loai", MySqlDbType.String);
        loaisp.Value = loai;
        newCmd.CommandText = queryString;
        newCmd.Parameters.Add(maloaisp);
        newCmd.Parameters.Add(loaisp);
        using (MySqlDataReader reader = newCmd.ExecuteReader())
        {
            // Kiểm tra có kết quả trả về
            if (reader.HasRows)
            { // Đọc từng dòng kết quả cho đến hết
                while (reader.Read())
                {

                    _productList.Add(new Product(reader[0].ToString(), reader[1].ToString(), reader[2].ToString(), reader.GetDouble(3), reader[4].ToString(), reader[5].ToString(), reader[6].ToString(), reader.GetInt32(7), reader[8].ToString(), reader[9].ToString()));
                }
            }
            else Console.WriteLine("No rows found.");
        }
        conn.Close();
        foreach (Product p in _productList)
        {
            p.imageMain = getImageMain(p.id_sanpham);
        }
        return _productList;
        */
        return null;
    }
    public List<Product> GetProductsBySearch(String keyword)
    {
        List<Product> result = new ArrayList<Product>();
        String sql  = "select a.product_id,a.product_name,a.category_id,a.price,b.promotion_rate,a.promotion_id" +
                ",a.brand,c.category_name,a.inventoryquantity,a.description,a.active,a.create_date,a.update_date " +
                "FROM promotion b JOIN product a  on b.promotion_id=a.promotion_id " +
                "JOIN category c on a.category_id=c.category_id where a.product_name like ?";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,keyword);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Product(rs.getString("product_id"), rs.getString("product_name")
                        ,rs.getString("category_id"),rs.getDouble("price")
                        ,rs.getDouble("promotion_rate"),rs.getString("promotion_id")
                        ,rs.getString("brand"),rs.getString("category_name")
                        ,rs.getInt("inventoryquantity"),rs.getString("description")
                        ,rs.getInt("active")));
            }
            rs.close();

            return result;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
