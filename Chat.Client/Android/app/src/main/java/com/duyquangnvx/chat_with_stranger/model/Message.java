package com.duyquangnvx.chat_with_stranger.model;

public class Message {
    private User sender;
    private String time;
    private String content;

    public Message() {
        this.sender = new User();
        this.time = "";
        this.content = "";
    }

    public Message(User sender, String time, String content) {
        this.sender = sender;
        this.time = time;
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
