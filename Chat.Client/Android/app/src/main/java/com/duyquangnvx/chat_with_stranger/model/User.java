package com.duyquangnvx.chat_with_stranger.model;

public class User {
    private String username;

    public static String MY_ID;

    public User(){
        this.username = "";
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
