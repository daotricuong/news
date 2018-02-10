package com.News.implement;


import com.News.DAO.CatalogueDaoImp;
import com.News.DAO.TopicDaoImp;
import com.News.Entity.Catalogue;
import com.News.Entity.ListTopic;
import com.News.Service.CatalogueShow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueShowimp implements CatalogueShow{


    public List<Catalogue> getAllCatalogue() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CatalogueDaoImp daoImp = (CatalogueDaoImp) context.getBean("catalogueDAO");
        List<Catalogue> list = daoImp.getAllCatalogue();
        return  list;
    }
    public List<Catalogue> getCatalogue(String catalogueId) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CatalogueDaoImp daoImp = (CatalogueDaoImp) context.getBean("catalogueDAO");
        List<Catalogue> list = daoImp.getCatalogue(catalogueId);
        return  list;
    }
    public List<ListTopic> getCatalogueTopic(String catalogueId) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CatalogueDaoImp daoImp = (CatalogueDaoImp) context.getBean("catalogueDAO");
        List<ListTopic> list = daoImp.getCatalogueTopic(catalogueId);
        return  list;
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
