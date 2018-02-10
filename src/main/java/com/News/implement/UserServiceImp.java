package com.News.implement;

import com.News.DAO.UserDaoImp;
import com.News.Entity.User;
import com.News.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;



@Service
public class UserServiceImp implements UserService {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String message;
    @Override
    public List<User> getAllUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImp daoImp = (UserDaoImp) context.getBean("userDao");
        return daoImp.listUser();
    }

    @Override
    public boolean create(HttpServletRequest httpServletRequest) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImp daoImp = (UserDaoImp) context.getBean("userDao");
        User user = (User) context.getBean("user");
        if (httpServletRequest.getParameter("password") == httpServletRequest.getParameter("repassword")){
            user.setUsername(httpServletRequest.getParameter("username"));
            user.setName(httpServletRequest.getParameter("name"));
            user.setPassword(httpServletRequest.getParameter("password"));
            if (httpServletRequest.getParameter("role") == null){
                user.setRole("0");
            }
            return daoImp.create(user);
        } else {
            this.setMessage("mật khẩu không trùng với mật khẩu xác nhận");
            return false;
        }

    }

    @Override
    public User getUser(String id) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImp daoImp = (UserDaoImp) context.getBean("userDao");
        return daoImp.getUser(id);
    }

    @Override
    public List<User> listuser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImp daoImp = (UserDaoImp) context.getBean("userDao");
        List<User> user =  daoImp.listUser();
        return user;
    }

    @Override
    public boolean delete(String id) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImp daoImp = (UserDaoImp) context.getBean("topicDAO");
        try{
            return daoImp.delete(id);
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(User user, String id) {
        return false;
    }

    @Override
    public boolean canLogin(HttpServletRequest requestUser) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImp daoImp = (UserDaoImp) context.getBean("userDao");
        boolean checkLogin = false;
        List<User> user =  daoImp.listUser();
        for(User check : user){
            System.out.println("tu login = " + requestUser.getParameter("username") + " user tu database = " + check.getUsername());
            System.out.println("tu login = " + requestUser.getParameter("password") + " pass tu database = " + check.getPassword());
            System.out.println("check = " + requestUser.getParameter("username") == check.getUsername() & requestUser.getParameter("password") == check.getPassword());
            if(requestUser.getParameter("username").equals(check.getUsername()) & requestUser.getParameter("password").equals(check.getPassword())){
                checkLogin = true;
            }
        }
        System.out.println("check login hiện tại  = " +checkLogin);
        return checkLogin;
    }
}
