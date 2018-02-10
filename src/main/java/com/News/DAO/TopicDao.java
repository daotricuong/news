package com.News.DAO;

import com.News.Entity.ListTopic;
import com.News.Entity.Topic;
import javax.sql.DataSource;
import java.util.List;


public interface TopicDao {

    public void setDataSource(DataSource ds);

    public boolean createTopic(Topic topic);

    public List<Topic> getTopic(String id);

    public List<Topic> getAllTopic();

    public ListTopic getCatalogueTopic(String catalogueName);

    public List<ListTopic> homeTopic();

    public boolean delete(String id);


    public boolean updateTopic(Topic topic, String id);

    public void hitView(int id);
}
