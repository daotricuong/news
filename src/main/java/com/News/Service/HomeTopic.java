package com.News.Service;

import com.News.Entity.ListTopic;
import com.News.Entity.Topic;

import java.util.List;

public interface HomeTopic {
    public ListTopic top3Topic();
    public List<ListTopic> getHomeTopic();
    public ListTopic getTopCommentTopic();
    public ListTopic getTopNewTopic();
}
