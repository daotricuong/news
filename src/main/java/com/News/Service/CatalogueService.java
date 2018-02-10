package com.News.Service;

import com.News.Entity.Catalogue;
import com.News.Entity.ListTopic;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CatalogueService {

    public boolean createCatalogue(HttpServletRequest topicRequest);


    public List<ListTopic> getCatalogueTopic(String id);

    public List<Catalogue>  getAllCatalogue();
    public List<Catalogue>  getCatalogue(String id);

    public boolean deleteCatalogue(String id);

    public boolean updateCatalogue(HttpServletRequest request, String id);
}
