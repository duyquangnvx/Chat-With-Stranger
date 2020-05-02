package com.duyquangnvx.chat_with_stranger.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.duyquangnvx.chat_with_stranger.model.User;
import com.duyquangnvx.chat_with_stranger.utils.SocketIO;
import com.github.nkzawa.emitter.Emitter;

public class LoginViewModel extends BaseViewModel {
    private User user;
    private MutableLiveData<Boolean> isLoginSuccess;

    public LoginViewModel() {
        this.user = new User();
        this.isLoginSuccess = new MutableLiveData<>();

        loginListener();
    }

    public void setUsername(String username){
        user.setUsername(username);
    }

    public String getUsername(){
        return user.getUsername();
    }

    public LiveData<Boolean> isLoginSuccess() {
        return this.isLoginSuccess;
    }

    public void onClickConnect(){
        // Notify to View show progress
        setIsShowProgress(true, "Waiting for stranger...");

        SocketIO.getInstance().getSocket().connect();
        SocketIO.getInstance().getSocket().on("server-send-userId", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                User.MY_ID = (String)args[0];
                user.setId((User.MY_ID));
            }
        });

        SocketIO.getInstance().getSocket().emit("client-send-username", user.getUsername());
    }

    private void loginListener() {
        // Server send userId and roomId
        SocketIO.getInstance().getSocket().on("server-send-roomId", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                ChatViewModel.ROOM_ID = (String)args[0];

                // Notify to View hide progress
                setIsShowProgress(false);
                isLoginSuccess.postValue(true);
            }
        });
    }
}
