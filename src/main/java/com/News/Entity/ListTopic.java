package com.News.Entity;

import java.util.List;

public class ListTopic {
    private String listId;
    private String listName;
    private List<Topic> topics;



    public ListTopic() {

    }

    public String getListId() {
        return listId;
    }

    public void setListId(String idCalalogue) {
        this.listId = idCalalogue;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String nameCalalogue) {
        this.listName = nameCalalogue;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "ListTopic{" +
                "idCalalogue='" + listId + '\'' +
                ", nameCalalogue='" + listName + '\'' +
                ", topics=" + topics +
                '}';
    }
}
