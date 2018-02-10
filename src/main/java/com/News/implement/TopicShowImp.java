package com.News.implement;

import com.News.DAO.TopicDaoImp;
import com.News.Entity.ListTopic;
import com.News.Entity.Topic;
import com.News.Service.TopicShow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TopicShowImp implements TopicShow {

    public List<Topic> getTopicId(String topicId) {
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            TopicDaoImp daoImp = (TopicDaoImp) context.getBean("topicDAO");
            List<Topic> topic =  daoImp.getTopic(topicId);
        return topic;
    }
    public List<Topic> getTopicForAdmin(String topicId) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TopicDaoImp daoImp = (TopicDaoImp) context.getBean("topicDAO");
        List<Topic> topic =  daoImp.getTopicForAdmin(topicId);
        return topic;
    }
    @Override
    public List<Topic> getAllTopic() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TopicDaoImp daoImp = (TopicDaoImp) context.getBean("topicDAO");
        List<Topic> topic =  daoImp.getAllTopic();

        System.out.println("status laf : " + topic.get(0).topicStatus());
        return topic;
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

    public ListTopic getTopViewTopic(int i) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TopicDaoImp daoImp = (TopicDaoImp) context.getBean("topicDAO");
        ListTopic topic =  daoImp.topViewTopic(i);
        return topic;
    }

}
