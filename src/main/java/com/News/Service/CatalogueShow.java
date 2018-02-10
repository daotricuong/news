package com.News.Service;

import com.News.Entity.Catalogue;
import com.News.Entity.ListTopic;

import java.util.List;

public interface CatalogueShow {
    public List<Catalogue> getAllCatalogue();
    public List<ListTopic> getCatalogueTopic(String catalogueId);
    public ListTopic getTopCommentTopic();
    public ListTopic getTopNewTopic();
}
