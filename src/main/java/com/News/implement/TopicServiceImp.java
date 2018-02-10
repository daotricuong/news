package com.News.implement;

import com.News.DAO.TopicDaoImp;
import com.News.Entity.Catalogue;
import com.News.Entity.Topic;
import com.News.Service.TopicService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Service
public class TopicServiceImp implements TopicService {
    @Override
    public boolean createTopic(HttpServletRequest topicRequest) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TopicDaoImp daoImp = (TopicDaoImp) context.getBean("topicDAO");
        Topic topic = (Topic) context.getBean("topic");
        topic.setTopicName(topicRequest.getParameter("topicName"));
        topic.setTopicDes(topicRequest.getParameter("topicDes"));
        topic.setTopicBody(topicRequest.getParameter("topicBody"));
        topic.setAuthorId(Integer.parseInt(topicRequest.getParameter("topicAuthorId")));
        topic.setTopicCover(topicRequest.getParameter("topicCover"));
        topic.setTagStr(topicRequest.getParameter("topicTag"));
        topic.setCatalogue(new Catalogue(topicRequest.getParameter("topicCatalogueid")));
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        topic.setCreateDay(date);
        topic.setTopicStatus(false);
        System.out.println(topic.toString());
        return daoImp.createTopic(topic);

    }

    @Override
    public boolean delete(String id) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TopicDaoImp daoImp = (TopicDaoImp) context.getBean("topicDAO");
        try{
            return daoImp.delete(id);
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateTopic(HttpServletRequest topicRequest,String id) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TopicDaoImp daoImp = (TopicDaoImp) context.getBean("topicDAO");
        Topic topic = (Topic) context.getBean("topic");
        topic.setTopicName(topicRequest.getParameter("topicName"));
        topic.setTopicDes(topicRequest.getParameter("topicDes"));
        topic.setTopicBody(topicRequest.getParameter("topicBody"));
        topic.setAuthorId(Integer.parseInt(topicRequest.getParameter("topicAuthorId")));
        topic.setTopicCover(topicRequest.getParameter("topicCover"));
        topic.setTagStr(topicRequest.getParameter("topicTag"));
        topic.setCatalogue(new Catalogue(topicRequest.getParameter("topicCatalogueid")));
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        topic.setCreateDay(date);
        topic.setTopicStatus(false);
        System.out.println(topic.toString());
        return daoImp.updateTopic(topic,topicRequest.getParameter("topicId"));
    }
    @Override
    public void find(String id) {
    }


    @Override
    public boolean changeStatus(String id,int status) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TopicDaoImp daoImp = (TopicDaoImp) context.getBean("topicDAO");
        try{
            daoImp.statusChange(id, status);
            return true;
        } catch (Exception e){
            return false;
        }
    }



    @Override
    public void hitView(int id) {

    }
}
