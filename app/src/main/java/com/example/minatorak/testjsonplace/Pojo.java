package com.example.minatorak.testjsonplace;

import com.google.gson.annotations.Expose;


public class Pojo {
    @Expose
    int userId;
    @Expose
    int id;
    @Expose
    String title;
    @Expose
    String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
