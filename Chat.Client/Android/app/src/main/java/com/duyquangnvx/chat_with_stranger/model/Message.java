package com.duyquangnvx.chat_with_stranger.model;

public class Message {
    private User sender;
    private String content;
    private String time;

    public Message() {
        this.sender = new User();
        this.content = "";
        this.time = "";
    }

    public Message(User sender, String content, String time) {
        this.sender = sender;
        this.content = content;
        this.time = time;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
