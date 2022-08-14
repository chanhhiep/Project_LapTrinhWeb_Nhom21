package vn.hcmuaf.edu.vn.project_web.Service.AdminService;

import vn.hcmuaf.edu.vn.project_web.Dao.AdminDao.UserDao;
import vn.hcmuaf.edu.vn.project_web.beans.User;

import java.util.List;

public class UserAdminService {
    private static UserAdminService instance;

    public static UserAdminService getInstance(){
        if(instance==null){
            instance=new UserAdminService();
        }
        return instance;
    }
    private UserAdminService(){

    }
    public List<User> getAllUser(){

        for(User p: UserDao.getInstance().getAllUser()){
            System.out.println(p.toString());
        }
        return UserDao.getInstance().getAllUser();
    }

    public boolean SaveUser(String user_name,String password,String email,String customer_id){
        return UserDao.getInstance().SaveUser(user_name,password,email,customer_id);
    }
    public boolean UpdateUserById(String user_id,String user_name,String password,String role,String email,String customer_id,int active){
        return UserDao.getInstance().UpdateUserById(user_id, user_name, password, role, email, customer_id, active);
    }
    public boolean DeleteUserById(String User_id){
        return UserDao.getInstance().DeleteUserById(User_id);
    }
    public static User CheckLogin(String username, String password){
        return UserDao.getInstance().CheckLogin(username,password);
    }
}
