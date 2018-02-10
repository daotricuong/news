package com.News.DAO;

import com.News.Entity.User;

import java.util.List;
import javax.sql.DataSource;

public interface UserDAO {

    public void setDataSource(DataSource ds);


    public boolean create(User user);


    public User getUser(String id);


    public List<User> listUser();


    public boolean delete(String id);

    public boolean statusChange(String id, int status);

    public boolean update(User user, String id);
}