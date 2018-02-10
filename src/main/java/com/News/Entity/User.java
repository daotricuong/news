package com.News.Entity;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class User {
    private String id;
    private String name;
    private String username;
    private String password;
    private boolean status;
    private String role;
    private List<Topic> createTopic;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Topic> getCreateTopic() {
        return createTopic;
    }

    public void setCreateTopic(List<Topic> createTopic) {
        this.createTopic = createTopic;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private String avatar;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public User(String id, String name, String address, boolean status, String role) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void info() {
        System.out.println("Info: " + this.toString());
    }

    @Override
    public String toString() {
        return "id = " + this.id + "\nName = " + this.name;

    }
}
