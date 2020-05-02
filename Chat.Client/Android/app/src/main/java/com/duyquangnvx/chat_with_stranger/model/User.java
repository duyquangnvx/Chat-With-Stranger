package com.duyquangnvx.chat_with_stranger.model;

public class User {
    public static String MY_ID;

    private String id;
    private String username;

    public User(){
        this.id = "";
        this.username = "";
    }

    public User(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isMe() {
        return this.id.equals(User.MY_ID);
    }
}
