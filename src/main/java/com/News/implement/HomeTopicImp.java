package com.News.implement;

import com.News.DAO.TopicDaoImp;
import com.News.Entity.ListTopic;
import com.News.Service.HomeTopic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HomeTopicImp implements HomeTopic{


    public ListTopic top3Topic() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TopicDaoImp daoImp = (TopicDaoImp) context.getBean("topicDAO");
        ListTopic topic =  daoImp.top3Topic();
        return topic;
    }

    public List<ListTopic> getHomeTopic() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<ListTopic> homeTopic;
        TopicDaoImp daoImp = (TopicDaoImp) context.getBean("topicDAO");
        homeTopic = daoImp.homeTopic();
        return homeTopic;
    }

    public ListTopic getTopCommentTopic() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TopicDaoImp daoImp = (TopicDaoImp) context.getBean("topicDAO");
        ListTopic topic =  daoImp.topCommentTopic();
        return topic;
    }

    public ListTopic getTopNewTopic() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TopicDaoImp daoImp = (TopicDaoImp) context.getBean("topicDAO");
        ListTopic topic =  daoImp.topNewTopic();
        return topic;
    }
}
