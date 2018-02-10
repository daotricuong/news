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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Repository


public class TopicDaoImp implements TopicDao {
    private DataSource dataSourceTemplate;
    private JdbcTemplate jdbcTemplate;

    public TopicDaoImp() {
    }

    public TopicDaoImp(DataSource dataSource) {
        dataSourceTemplate = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setDataSource(DataSource dataSource) {
        dataSourceTemplate = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean updateTopic(Topic topic, String id) {
        String sql = "UPDATE [NEWS].[dbo].[NewsTopic] SET " +
                "topicname=?, topicdescription=?,topicbody=?,authorid=?,topiccover=?,topiccatalogue=?,createday=?,topictag=?,topicstatus=? WHERE topicid = '" + id + "'";


        return jdbcTemplate.update(sql, new Object[]{
                topic.getTopicName(), topic.getTopicDes(), topic.getTopicBody(), topic.getAuthorId(), topic.getTopicCover(), topic.getCatalogue().getCatalogueid(), topic.getCreateDay(), topic.getTagStr(), topic.topicStatus()
        }) == 1;
    }

    public void statusChange(String id, int status) {
        String sql = "UPDATE [NEWS].[dbo].[NewsTopic] SET " +
                "topicstatus=? WHERE topicid = '" + id + "'";

        jdbcTemplate.update(sql, new Object[]{
                status
        });
    }


    public boolean createTopic(Topic topic) {
        String sql = "INSERT  INTO [NEWS].[dbo].[NewsTopic]" +
                "(topicname, topicdescription,topicbody,authorid,topiccover,topiccatalogue,createday,topictag,topicstatus,likecount,commentcount,viewcount,dislikecount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";

try{
    jdbcTemplate.update(sql, new Object[]{
            topic.getTopicName(), topic.getTopicDes(), topic.getTopicBody(), topic.getAuthorId(), topic.getTopicCover(), topic.getCatalogue().getCatalogueid(), topic.getCreateDay(), topic.getTagStr(), topic.topicStatus(), 0, 0, 0, 0
    });
    return true;
} catch (Exception e){
    return false;
}


    }

    @Override
    public List<Topic> getAllTopic() {
        String sql = "SELECT * FROM [NEWS].[dbo].[NewsTopic] ";
        List<Topic> list = jdbcTemplate.query(sql, new RowMapper<Topic>() {


            public Topic mapRow(ResultSet resultSet, int i) throws SQLException {
                List<String> tagList = new ArrayList<String>();
                ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                Topic topic = (Topic) context.getBean("topic");
                topic.setTopicId(resultSet.getString("topicid"));
                topic.setTopicDes(resultSet.getString("topicdescription"));
                topic.setTopicName(resultSet.getString("topicname"));
                topic.setTopicBody(resultSet.getString("topicbody"));
                topic.setTopicCover(resultSet.getString("topiccover"));
                topic.setCreateDay(resultSet.getDate("createday"));
                topic.setLikeCount(resultSet.getInt("likecount"));
                topic.setAuthorId(resultSet.getInt("authorid"));
                topic.setLikeCount(resultSet.getInt("viewcount"));
                topic.setTopicStatus(resultSet.getBoolean("topicstatus"));
                topic.setCommentCount(resultSet.getInt("commentcount"));
                if (resultSet.getString("topictag") != null && resultSet.getString("topictag").contains(",")) {
                    String[] items = resultSet.getString("topictag").split(",");
                    for (String item : items) {
                        tagList.add(item);
                    }
                } else {
                    if (resultSet.getString("topictag") == (null)) {
                        tagList.add(null);
                    } else {
                        tagList.add(resultSet.getString("topictag"));
                    }

                }
                topic.setTag(tagList);
//                =====================
                String sql = "SELECT * FROM [NEWS].[dbo].[Catalogues] WHERE catalogueid = '" + resultSet.getString("topiccatalogue") + "'";
                List<Catalogue> list1 = jdbcTemplate.query(sql, new RowMapper<Catalogue>() {


                    public Catalogue mapRow(ResultSet resultSet, int i) throws SQLException {
                        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                        Catalogue catalogue = (Catalogue) context.getBean("catalogue");
                        catalogue.setCatalogueName(resultSet.getString("cataloguename"));
                        return catalogue;
                    }
                });

                if (!list1.isEmpty()) {

                    topic.setCatalogue(list1.get(0));

                } else topic.setCatalogue(new Catalogue("không xác định", "không xác định"));

//                ================


                return topic;
            }
        });

        return list;
    }

    public List<Topic> getTopic(String id) {
        String sql = "SELECT * FROM [NEWS].[dbo].[NewsTopic] WHERE topicstatus = 1 AND topicid= '" + id + "'";
        List<Topic> list = jdbcTemplate.query(sql, new RowMapper<Topic>() {


            public Topic mapRow(ResultSet resultSet, int i) throws SQLException {
                List<String> tagList = new ArrayList<String>();
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
                if (resultSet.getString("topictag") != null && resultSet.getString("topictag").contains(",")) {
                    String[] items = resultSet.getString("topictag").split(",");
                    for (String item : items) {
                        tagList.add(item);
                    }
                } else {
                    if (resultSet.getString("topictag") == (null)) {
                        tagList.add(null);
                    } else {
                        tagList.add(resultSet.getString("topictag"));
                    }

                }
                topic.setTag(tagList);
//                  =====================
                String sql = "SELECT * FROM [NEWS].[dbo].[Catalogues] WHERE catalogueid = '" + resultSet.getString("topiccatalogue") + "'";
                List<Catalogue> list1 = jdbcTemplate.query(sql, new RowMapper<Catalogue>() {


                    public Catalogue mapRow(ResultSet resultSet, int i) throws SQLException {
                        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                        Catalogue catalogue = (Catalogue) context.getBean("catalogue");
                        catalogue.setCatalogueid(resultSet.getString("catalogueid"));
                        catalogue.setCatalogueName(resultSet.getString("cataloguename"));
                        catalogue.setCatalogueNumber(resultSet.getInt("cataloguenumber"));
                        return catalogue;
                    }
                });

                if (!list1.isEmpty()) {

                    topic.setCatalogue(list1.get(0));

                } else topic.setCatalogue(new Catalogue("không xác định", "không xác định"));

//                ================

                return topic;
            }
        });

        return list;


    }

    public List<Topic> getTopicForAdmin(String id) {
        String sql = "SELECT * FROM [NEWS].[dbo].[NewsTopic] WHERE topicid= '" + id + "'";
        List<Topic> list = jdbcTemplate.query(sql, new RowMapper<Topic>() {


            public Topic mapRow(ResultSet resultSet, int i) throws SQLException {
                List<String> tagList = new ArrayList<String>();
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
                if (resultSet.getString("topictag") != null && resultSet.getString("topictag").contains(",")) {
                    String[] items = resultSet.getString("topictag").split(",");
                    for (String item : items) {
                        tagList.add(item);
                    }
                } else {
                    if (resultSet.getString("topictag") == (null)) {
                        tagList.add(null);
                    } else {
                        tagList.add(resultSet.getString("topictag"));
                    }

                }
                topic.setTag(tagList);
//                  =====================
                String sql = "SELECT * FROM [NEWS].[dbo].[Catalogues] WHERE catalogueid = '" + resultSet.getString("topiccatalogue") + "'";
                List<Catalogue> list1 = jdbcTemplate.query(sql, new RowMapper<Catalogue>() {


                    public Catalogue mapRow(ResultSet resultSet, int i) throws SQLException {
                        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                        Catalogue catalogue = (Catalogue) context.getBean("catalogue");
                        catalogue.setCatalogueid(resultSet.getString("catalogueid"));
                        catalogue.setCatalogueName(resultSet.getString("cataloguename"));
                        catalogue.setCatalogueNumber(resultSet.getInt("cataloguenumber"));
                        return catalogue;
                    }
                });

                if (!list1.isEmpty()) {

                    topic.setCatalogue(list1.get(0));

                } else topic.setCatalogue(new Catalogue("không xác định", "không xác định"));

//                ================

                return topic;
            }
        });

        return list;


    }


    public ListTopic getCatalogueTopic(String catalogueName) {
        String sql = "SELECT TOP 10 * FROM [NEWS].[dbo].[NewsTopic] WHERE topicstatus = 1 AND topicCatalogue = '" + catalogueName + "'";
        ListTopic listTopicFromCatalogue = new ListTopic();
        listTopicFromCatalogue.setListId(catalogueName);
        listTopicFromCatalogue.setTopics(jdbcTemplate.query(sql, new RowMapper<Topic>() {


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
                String[] items = resultSet.getString("topictag").split(",");
                List<String> itemList = new ArrayList<String>();
                for (String item : items) {
                    itemList.add(item);
                }
                topic.setTag(itemList);
                return topic;
            }
        }));

        return listTopicFromCatalogue;
    }

    public List<ListTopic> homeTopic() {
        String sql = "SELECT * FROM [NEWS].[dbo].[Catalogues]";
        List<ListTopic> homeTopic = jdbcTemplate.query(sql, new RowMapper<ListTopic>() {

            public ListTopic mapRow(ResultSet resultSet, int i) throws SQLException {
                ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                ListTopic listTopic = (ListTopic) context.getBean("listTopic");
                listTopic.setListId(resultSet.getString("catalogueid"));
                listTopic.setListName(resultSet.getString("cataloguename"));
                final String sql = "SELECT TOP 2 * FROM [NEWS].[dbo].[NewsTopic] WHERE topicstatus = 1 AND topicCatalogue = '" + listTopic.getListId() + "'";
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
                                String[] items = resultSet.getString("topictag").split(",");
                                List<String> itemList = new ArrayList<String>();
                                for (String item : items) {
                                    itemList.add(item);
                                }
                                topic.setTag(itemList);
                                return topic;
                            }
                        })
                );
                return listTopic;
            }
        });
        return homeTopic;
    }

    public ListTopic topCommentTopic() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ListTopic listTopic = (ListTopic) context.getBean("listTopic");
        listTopic.setListId("");
        listTopic.setListName("");
        String sql = "SELECT TOP 4 * FROM [NEWS].[dbo].[NewsTopic] WHERE topicstatus = 1 ORDER BY commentcount DESC";
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

    public ListTopic topNewTopic() {


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ListTopic listTopic = (ListTopic) context.getBean("listTopic");
        listTopic.setListId("");
        listTopic.setListName("");
        String sql = "SELECT TOP 10 * FROM [NEWS].[dbo].[NewsTopic] WHERE topicstatus = 1 ORDER BY createday DESC";
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

    public ListTopic top3Topic() {


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ListTopic listTopic = (ListTopic) context.getBean("listTopic");
        listTopic.setListId("");
        listTopic.setListName("");
        String sql = "SELECT TOP 3 * FROM [NEWS].[dbo].[NewsTopic] WHERE topicstatus = 1 ORDER BY commentcount DESC , createday DESC";
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

    public ListTopic topViewTopic(int i) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ListTopic listTopic = (ListTopic) context.getBean("listTopic");
        listTopic.setListId("");
        listTopic.setListName("");
        int from = (i - 1) * 10 + 1;
        int to = i * 10;
        String sql = " SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY viewcount) AS Row, * FROM [NEWS].[dbo].[NewsTopic] ) us WHERE topicstatus = 1 AND Row BETWEEN " + from + " AND " + to;
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


    public boolean delete(String id) {
        String sql = "DELETE FROM [NEWS].[dbo].[NewsTopic] WHERE topicid = ?";
        Object[] args = new Object[]{id};
        try {
            jdbcTemplate.update(sql, args);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void update(String id) {

    }

    public void hitView(int id) {

        String sql = "UPDATE [NEWS].[dbo].[NewsTopic] SET viewcount =  + viewcount + 1 + Where topicid= " + id;
        jdbcTemplate.execute(sql);

    }

}