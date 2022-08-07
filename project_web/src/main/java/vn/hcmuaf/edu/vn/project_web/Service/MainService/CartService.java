package vn.hcmuaf.edu.vn.project_web.Service.MainService;

import vn.hcmuaf.edu.vn.project_web.beans.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CartService {
    private static CartService instance = null;
    private CartService(){

    }
    public static CartService getInstance() {
        if(instance==null){
            instance= new CartService();
        }
        return instance;
    }
    //phương thức check xem sản phẩm đã tồn tại trong giỏ hàng hay chưa
    //nếu đã tồn tại trả về index vị trí
    public int isExits(String product_id, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        List<CartItem> items =  (List<CartItem>) session.getAttribute("cart");
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getCart_product().getProduct_id().equals(product_id))
            {
                return i;
            }
        }
        return -1;
    }
}
