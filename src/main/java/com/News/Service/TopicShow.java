package com.News.Service;

import com.News.Entity.ListTopic;
import com.News.Entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TopicShow {

    public List<Topic> getTopicId(String topicId);
    public List<Topic> getTopicForAdmin(String topicId);
    public List<Topic> getAllTopic();
    public ListTopic getTopCommentTopic();
    public ListTopic getTopNewTopic();
    public ListTopic getTopViewTopic(int i);
}
