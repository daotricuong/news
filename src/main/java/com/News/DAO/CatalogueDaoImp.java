package com.News.DAO;

import com.News.Entity.Catalogue;
import com.News.Entity.ListTopic;
import com.News.Entity.Topic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public class CatalogueDaoImp implements CatalogueDAO {
    private DataSource dataSourceTemplate;
    private JdbcTemplate jdbcTemplate;

    public CatalogueDaoImp() {
    }

    public CatalogueDaoImp(DataSource dataSource) {
        dataSourceTemplate = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setDataSource(DataSource dataSource) {
        dataSourceTemplate = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean updateCatalogue(Catalogue catalogue, String id) {
        String sql = "UPDATE [NEWS].[dbo].[Catalogues] SET " +
                "cataloguename=?, cataloguedes=?,cataloguenumber=? WHERE catalogueid = '" + id + "'";


        try{
            jdbcTemplate.update(sql, new Object[]{
                    catalogue.getCatalogueName(),catalogue.getCatalogueDes(),catalogue.getCatalogueNumber()});
            return true;
        } catch (Exception e){
            return false;
        }

    }

    public boolean createCatalogue(Catalogue catalogue) {
        String sql = "INSERT  INTO [NEWS].[dbo].[Catalogues]" +
                "(catalogueid, cataloguename,cataloguedes,cataloguenumber) VALUES (?,?, ?, ?)";

        try {
            jdbcTemplate.update(sql, new Object[]{
                    catalogue.getCatalogueid(), catalogue.getCatalogueName(), catalogue.getCatalogueDes(), catalogue.getCatalogueNumber()
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Catalogue>  getAllCatalogue() {

        String sql = "SELECT * FROM [NEWS].[dbo].[Catalogues] ORDER BY cataloguenumber ";
        List<Catalogue> list = jdbcTemplate.query(sql, new RowMapper<Catalogue>() {
            public Catalogue mapRow(ResultSet resultSet, int i) throws SQLException {
                ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                Catalogue catalogue = (Catalogue) context.getBean("catalogue");
                catalogue.setCatalogueid(resultSet.getString("catalogueid"));
                catalogue.setCatalogueName(resultSet.getString("cataloguename"));
                catalogue.setCatalogueDes(resultSet.getString("cataloguedes"));
                catalogue.setCatalogueNumber(resultSet.getInt("cataloguenumber"));
                return catalogue;
            }
        });

        return list;
    }
    public List<Catalogue>  getCatalogue(String catalogueId) {

//        String sql = "SELECT * FROM [NEWS].[dbo].[Catalogues] WHERE catalogueid = '" + catalogueId + "'";
//        List<Catalogue> list = jdbcTemplate.query(sql, new RowMapper<Catalogue>() {
//            public Catalogue mapRow(ResultSet resultSet, int i) throws SQLException {
//                ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//                Catalogue catalogue = (Catalogue) context.getBean("catalogue");
//                catalogue.setCatalogueid(resultSet.getString("catalogueid"));
//                catalogue.setCatalogueName(resultSet.getString("cataloguename"));
//                catalogue.setCatalogueNumber(resultSet.getInt("cataloguenumber"));
//                return catalogue;
//            }
//        });

        String sql = "SELECT * FROM [NEWS].[dbo].[Catalogues] WHERE catalogueid = '" + catalogueId + "'";
        List<Catalogue> list1 = jdbcTemplate.query(sql, new RowMapper<Catalogue>() {


            public Catalogue mapRow(ResultSet resultSet, int i) throws SQLException {
                ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                Catalogue catalogue = (Catalogue) context.getBean("catalogue");
                catalogue.setCatalogueid(resultSet.getString("catalogueid"));
                catalogue.setCatalogueName(resultSet.getString("cataloguename"));
                catalogue.setCatalogueNumber(resultSet.getInt("cataloguenumber"));
                catalogue.setGetCatalogueViewcount(resultSet.getInt("catalogueviewcount"));
                return catalogue;
            }
        });

        if (!list1.isEmpty()) {

            return  list1;

        } else
            list1.add(new Catalogue("không xác định", "không xác định"));
            return  list1;
    }


    public List<Catalogue> listCatalogue() {
        return null;
    }

    public List<ListTopic> getCatalogueTopic(String catalogueId) {
        String sql = "SELECT * FROM [NEWS].[dbo].[Catalogues] WHERE  catalogueid = '" + catalogueId + "'";
        List<ListTopic> homeTopic = jdbcTemplate.query(sql, new RowMapper<ListTopic>() {

            public ListTopic mapRow(ResultSet resultSet, int i) throws SQLException {
                ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                ListTopic listTopic = (ListTopic) context.getBean("listTopic");
                listTopic.setListId(resultSet.getString("catalogueid"));
                listTopic.setListName(resultSet.getString("cataloguename"));
                String sql = "SELECT * FROM [NEWS].[dbo].[NewsTopic] WHERE  topicstatus = 1 AND  topicCatalogue = '" + listTopic.getListId() + "'";
                listTopic.setTopics(jdbcTemplate.query(sql, new RowMapper<Topic>() {
                            public Topic mapRow(ResultSet resultSet, int i) throws SQLException {
                                ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                                Topic topic = (Topic) context.getBean("topic");
                                topic.setTopicId(resultSet.getString("topicid"));
                                topic.setTopicDes(resultSet.getString("topicdescription"));
                                topic.setTopicName(resultSet.getString("topicname"));
                                topic.setTopicBody(resultSet.getString("topicbody"));
                                topic.setTopicCover(resultSet.getString("topiccover"));
                                topic.setCreateDay(resultSet.getDate("createday"));
                                topic.setLikeCount(resultSet.getInt("likecount"));
                                topic.setLikeCount(resultSet.getInt("viewcount"));
                                topic.setCommentCount(resultSet.getInt("commentcount"));
                                return topic;
                            }
                        })
                );
                return listTopic;
            }
        });
        return homeTopic;
    }

    public boolean deleteCatalogue(String id) {

        String sql = "DELETE FROM [NEWS].[dbo].[Catalogues] WHERE catalogueid = ?";
        Object[] args = new Object[]{id};
        try {
            jdbcTemplate.update(sql, args);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    public void hitView(int id) {

        String sql = "UPDATE [NEWS].[dbo].[Topics] SET viewcount =  + viewcount + 1 + Where topicid= " + id;
        jdbcTemplate.execute(sql);

    }

}