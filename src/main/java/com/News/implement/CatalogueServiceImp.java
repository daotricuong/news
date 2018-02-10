package com.News.implement;

import com.News.DAO.CatalogueDaoImp;
import com.News.DAO.TopicDaoImp;
import com.News.Entity.Catalogue;
import com.News.Entity.ListTopic;
import com.News.Service.CatalogueService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
public class CatalogueServiceImp implements CatalogueService{

    @Override
    public boolean createCatalogue(HttpServletRequest request) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CatalogueDaoImp daoImp = (CatalogueDaoImp) context.getBean("catalogueDAO");
        Catalogue catalogue = (Catalogue) context.getBean("catalogue");
        try{
            catalogue.setCatalogueid(request.getParameter("catalogueId"));
            catalogue.setCatalogueName(request.getParameter("catalogueName"));
            catalogue.setCatalogueDes(request.getParameter("catalogueDes"));
            catalogue.setCatalogueNumber(Integer.parseInt(request.getParameter("catalogueNumber")));
            return daoImp.createCatalogue(catalogue);
        } catch (Exception e){
            return false;
        }

    }

    @Override
    public List<ListTopic> getCatalogueTopic(String id) {
        return null;
    }

    @Override
    public List<Catalogue> getAllCatalogue() {
        return null;
    }

    @Override
    public List<Catalogue> getCatalogue(String id) {
        return null;
    }

    @Override
    public boolean deleteCatalogue(String id) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CatalogueDaoImp daoImp = (CatalogueDaoImp) context.getBean("catalogueDAO");
        try{
            return daoImp.deleteCatalogue(id);
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCatalogue(HttpServletRequest request, String id) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CatalogueDaoImp daoImp = (CatalogueDaoImp) context.getBean("catalogueDAO");
        Catalogue catalogue = (Catalogue) context.getBean("catalogue");
        try{
            catalogue.setCatalogueName(request.getParameter("catalogueName"));
            catalogue.setCatalogueDes(request.getParameter("catalogueDes"));
            catalogue.setCatalogueNumber(Integer.parseInt(request.getParameter("catalogueNumber")));
            return daoImp.updateCatalogue(catalogue,id);
        } catch (Exception e){
            return false;
        }
    }
}
