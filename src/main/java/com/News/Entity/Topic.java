package com.News.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Topic {
    private String topicId;
    private String topicName;
    private String topicBody;
    private String topicCover;
    private String topicDes;
    private boolean topicStatus;
    private int authorId;
    private Date createDay;
    private int likeCount;
    private int dislikeCount;
    private int commentCount;
    private int viewCount;
    private List<String> tag;
    private Catalogue catalogue;


    public Topic(String topicId) {
        this.topicId = topicId;
    }

    public List<String> getTag() {
        return tag;
    }

    public Topic(String topicId, String topicName, String topicBody, String topicCover, String topicDes, boolean topicStatus, int authorId, Date createDay, int likeCount, int dislikeCount, int commentCount, int viewCount, List<String> tag, Catalogue catalogue) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicBody = topicBody;
        this.topicCover = topicCover;
        this.topicDes = topicDes;
        this.topicStatus = topicStatus;
        this.authorId = authorId;
        this.createDay = createDay;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.tag = tag;
        this.catalogue = catalogue;
    }

    public Topic(String topicId, String topicName, String topicBody, String topicCover, String topicDes, boolean topicStatus, int authorId, Date createDay, int likeCount, int dislikeCount, int commentCount, int viewCount, List<String> tag) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicBody = topicBody;
        this.topicCover = topicCover;
        this.topicDes = topicDes;
        this.topicStatus = topicStatus;
        this.authorId = authorId;
        this.createDay = createDay;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.tag = tag;

    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public Topic() {
    }
    public Topic(String topicName, String topicBody, String topicId) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicBody = topicBody;
    }

    public Topic(String topicId, String topicName, String topicBody, String topicCover, String topicDes, boolean topicStatus, int authorId, Date createDay, int likeCount, int dislikeCount, int commentCount, int viewCount) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicBody = topicBody;
        this.topicDes = topicDes;
        this.topicCover = topicCover;
        this.topicStatus = topicStatus;
        this.authorId = authorId;
        this.createDay = createDay;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
    }



    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicBody() {
        return topicBody;
    }

    public void setTopicBody(String topicBody) {
        this.topicBody = topicBody;
    }

    public String getTopicDes() {return topicDes; }

    public void setTopicDes(String topicDes) {this.topicDes = topicDes; }

    public String getTopicCover() {
        return topicCover;
    }

    public void setTopicCover(String topicCover) {
        this.topicCover = topicCover;
    }

    public boolean topicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(boolean topicStatus) {
        this.topicStatus = topicStatus;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }
    public String getTagStr(){
        if(tag.isEmpty()){
            return "";
        } else {
            String tagString = "";
            for (int i = 0; i < tag.size()-1;i++){
                tagString += tag.get(i) +",";
            }
            tagString += tag.get(tag.size()-1);
        return tagString;
        }
    }
    public void setTagStr(String str) {
        List<String> tagList = new ArrayList<String>();
        if (!str.equals(null)&&str.contains(",")) {
            String[] items = str.split(",");
            for (String item : items) {
                tagList.add(item);
            }
        } else {
            if (str == (null)) {
                tagList.add(null);
            } else {
                tagList.add(str);
            }
        }
        this.tag = tagList;
    }
    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicName='" + topicName + '\'' +
                ", topicBody='" + topicBody + '\'' +
                ", topicCover='" + topicCover + '\'' +
                ", topicStatus=" + topicStatus +
                ", authorId=" + authorId +
                ", createDay=" + createDay +
                ", likeCount=" + likeCount +
                ", dislikeCount=" + dislikeCount +
                ", commentCount=" + commentCount +
                ", viewCount=" + viewCount +
                '}';
    }
}
