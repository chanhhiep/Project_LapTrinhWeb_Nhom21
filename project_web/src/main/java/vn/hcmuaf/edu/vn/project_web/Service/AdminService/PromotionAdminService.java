package vn.hcmuaf.edu.vn.project_web.Service.AdminService;

import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.PromotionDao;
import vn.hcmuaf.edu.vn.project_web.beans.Promotion;


import java.util.List;

public class PromotionAdminService {
    private static PromotionAdminService instance;

    public static PromotionAdminService getInstance(){
        if(instance==null){
            instance=new PromotionAdminService();
        }
        return instance;
    }
    private PromotionAdminService(){

    }
    public List<Promotion> getAllPromotion(){

        for(Promotion p: PromotionDao.getInstance().getAllPromotion()){
            System.out.println(p.toString());
        }
        return PromotionDao.getInstance().getAllPromotion();
    }

    public boolean SavePromotion(String promotion_id,String promotion_name,double promotion_rate, String promotion_content){
        return PromotionDao.getInstance().SavePromotion(promotion_id,promotion_name,promotion_rate,promotion_content);
    }
    public boolean UpdatePromotionById(String promotion_id,String promotion_name,double promotion_rate, String promotion_content,int active){
        return PromotionDao.getInstance().UpdatePromotionById(promotion_id,promotion_name,promotion_rate,promotion_content,active);
    }
    public boolean DeletePromotionById(String promotion_id){
        return PromotionDao.getInstance().DeletePromotionById(promotion_id);
    }
}
