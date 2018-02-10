package com.News.DAO;

import com.News.Entity.Catalogue;
import com.News.Entity.ListTopic;

import javax.sql.DataSource;
import java.util.List;

public interface CatalogueDAO {

    public void setDataSource(DataSource ds);

    public boolean createCatalogue(Catalogue catalogue);


    public List<ListTopic> getCatalogueTopic(String id);

    public List<Catalogue>  getAllCatalogue();
    public List<Catalogue>  getCatalogue(String id);

    public List<Catalogue> listCatalogue();


    public boolean deleteCatalogue(String id);

    public boolean updateCatalogue(Catalogue catalogue, String id);
}
