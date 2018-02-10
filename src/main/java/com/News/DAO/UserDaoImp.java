package com.News.DAO;

import com.News.Entity.Topic;
import com.News.Entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class UserDaoImp implements UserDAO{
    private DataSource dataSourceTemplate;
    private JdbcTemplate jdbcTemplate;


    public UserDaoImp() {
    }

    public UserDaoImp(DataSource dataSource) {
        dataSourceTemplate = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setDataSource(DataSource dataSource) {
        dataSourceTemplate = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean create(User user) {
        String sql = "INSERT  INTO [NEWS].[dbo].[NewsUser]" +
                "(username=?, password=?, role = ?,status=? ) VALUES (?, ?, ?)";

        try{
            jdbcTemplate.update(sql, new Object[]{
                    user.getName(), user.getPassword(), user.getRole(),true});
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public User getUser(String id) {
        String sql = " SELECT * FROM [NEWS].[dbo].[NewsUser] WHERE userid = '" + id + "'";
        List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                User user = (User) context.getBean("user");
                user.setId(resultSet.getString("userid"));
                if(resultSet.getString("name") == null){
                    user.setName("anonymous");
                } else {
                    user.setName(resultSet.getString("name"));
                }
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(resultSet.getBoolean("status"));

                user.setRole(resultSet.getString("role"));
                String sql1 = "SELECT * FROM [NEWS].[dbo].[Catalogues] ORDER BY authorid = '" + resultSet.getString("userid") + "'";
                try{
                    user.setCreateTopic(jdbcTemplate.query(sql1, new RowMapper<Topic>() {


                        public Topic mapRow(ResultSet resultSet, int i) throws SQLException {
                            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                            Topic topic = (Topic) context.getBean("topic");
                            topic.setTopicId(resultSet.getString("topicid"));
                            return topic;
                        }
                    }));
                } catch (Exception e){
                    user.setCreateTopic(null);
                }

                return user;
            }
        });
        if (list.isEmpty()){
            return new User("không xác định");
        }
        return list.get(0);
    }

    @Override
    public List<User> listUser() {
        String sql = " SELECT * FROM [NEWS].[dbo].[NewsUser] ORDER BY name ";
        List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                User user = (User) context.getBean("user");
                user.setId(resultSet.getString("userid"));
                if(resultSet.getString("name") == null){
                    user.setName("anonymous");
                } else {
                    user.setName(resultSet.getString("name"));
                }
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(resultSet.getBoolean("status"));

                user.setRole(resultSet.getString("role"));
                String sql1 = "SELECT * FROM [NEWS].[dbo].[Catalogues] ORDER BY authorid = '" + resultSet.getString("userid") + "'";
                try{
                    user.setCreateTopic(jdbcTemplate.query(sql1, new RowMapper<Topic>() {


                        public Topic mapRow(ResultSet resultSet, int i) throws SQLException {
                            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                            Topic topic = (Topic) context.getBean("topic");
                            topic.setTopicId(resultSet.getString("topicid"));
                            return topic;
                        }
                    }));
                } catch (Exception e){
                    user.setCreateTopic(null);
                }

                return user;
            }
        });

        return list;
    }


    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM [NEWS].[dbo].[NewsUser] WHERE userid = ?";
        Object[] args = new Object[]{id};
        try {
            jdbcTemplate.update(sql, args);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean statusChange(String id, int status) {
        String sql = "UPDATE [NEWS].[dbo].[NewsUser] SET " +
                "status=? WHERE userid = '" + id + "'";

        try{
            jdbcTemplate.update(sql, new Object[]{
                    status
            });
            return true;
        } catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean update(User user, String id) {
        String sql = "UPDATE [NEWS].[dbo].[NewsUser] SET " +
                "name = ?, userpass=?, reoleid = ? WHERE userid = '" + id + "'";


        return jdbcTemplate.update(sql, new Object[]{
                user.getName(), user.getPassword(), user.getRole()}) == 1;
    }
}
