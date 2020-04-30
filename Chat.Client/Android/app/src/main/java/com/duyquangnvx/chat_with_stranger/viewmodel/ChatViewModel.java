package com.duyquangnvx.chat_with_stranger.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.duyquangnvx.chat_with_stranger.model.Message;
import com.duyquangnvx.chat_with_stranger.model.User;
import java.util.ArrayList;

public class ChatViewModel extends BaseViewModel {
    private String message;
    private ArrayList<Message> messages;
    private MutableLiveData<Boolean> isSendSuccess;

    public ChatViewModel() {
        this.isSendSuccess = new MutableLiveData<>();
        this.messages = new ArrayList<>(4);

        messages.add(new Message(new User("Quang"), "10:24 AM", "Hello"));
        messages.add(new Message(new User("Duy"), "10:24 AM", "Hi"));
        messages.add(new Message(new User("Quang"), "10:25 AM", "How are you today?"));
        messages.add(new Message(new User("Duy"), "10:26 AM", "I'm fine, thanks xD"));
    }

    private void send() {
        // Client gửi msg lên Server.
        // Server tạo 1 Message{sender, message, time} và broadcast về Client.Room
    }

    private void receive(Message message) {
        // Client check sender.Id
        //      + Nếu sender.Id == User.Id (là 1 static value) thì đó là SendMessage
        //      + Nếu != thì đó là ReceiveMessage
        // Add message vào messages;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Message> getMessages() { return this.messages; }

    public void setMessages(ArrayList<Message> messages) { this.messages = messages; }

    public LiveData<Boolean> isSendSuccess() { return this.isSendSuccess; }
}
