package com.duyquangnvx.chat_with_stranger.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.duyquangnvx.chat_with_stranger.model.Message;
import com.duyquangnvx.chat_with_stranger.model.User;
import com.duyquangnvx.chat_with_stranger.utils.SocketIO;
import com.github.nkzawa.emitter.Emitter;
import java.util.ArrayList;
import java.util.List;

public class ChatViewModel extends BaseViewModel {
    private String message;
    private List<Message> messages;
    private MutableLiveData<Boolean> isSent;
    private MutableLiveData<Boolean> isReceived;
    public static String ROOM_ID = "NONE";

    public ChatViewModel() {
        this.isSent = new MutableLiveData<>();
        this.isReceived = new MutableLiveData<>();
        this.messages = new ArrayList<>();

        receiveListener();
    }

    private void send() {
        // Client gửi msg lên Server.
        // Server tạo 1 Message{sender, message, time} và broadcast về Client.Room
        SocketIO.getInstance().getSocket().emit("client-send-message", ChatViewModel.ROOM_ID, this.message);
    }

    private void receiveListener() {
        // Client check sender.Id
        //      + Nếu sender.Id == User.Id (là 1 static value) thì đó là SendMessage
        //      + Nếu != thì đó là ReceiveMessage
        // Add message vào messages;

        SocketIO.getInstance().getSocket().on("server-send-message", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                User sender = new User((String)args[0], (String)args[1]);
                Message message = new Message(sender, (String)args[2], (String)args[3]);

                messages.add(message);
                isReceived.postValue(true);
            }
        });
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Message> getMessages() { return this.messages; }

    public void setMessages(ArrayList<Message> messages) { this.messages = messages; }

    public LiveData<Boolean> isSent() { return this.isSent; }
    public LiveData<Boolean> isReceived() { return this.isReceived; }

    public void onClickSendMessage() {
        send();
    }
}
