package com.News.Service;

import com.News.Entity.ListTopic;
import com.News.Entity.Topic;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TopicService {

    public boolean createTopic(HttpServletRequest topicRequest);

    public boolean delete(String id);

    public boolean updateTopic(HttpServletRequest topicRequest,String id);

    public void find(String id);

    public boolean changeStatus(String id,int status);

    public void hitView(int id);
}
