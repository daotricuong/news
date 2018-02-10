package com.News.Service;

import com.News.Entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {


    public List<User> getAllUser();


    public boolean create(HttpServletRequest httpServletRequest);


    public User getUser(String id);


    public List<User> listuser();


    public boolean delete(String id);


    public boolean update(User user, String id);

    public boolean canLogin(HttpServletRequest httpServletRequest);

}
