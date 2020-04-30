package com.duyquangnvx.chat_with_stranger.viewmodel;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.duyquangnvx.chat_with_stranger.model.User;

public class LoginViewModel extends BaseViewModel {
    private User user;
    private MutableLiveData<Boolean> isLoginSuccess;

    public LoginViewModel() {
        this.user = new User();
        this.isLoginSuccess = new MutableLiveData<>();
    }

    public void setUsername(String username){
        user.setUsername(username);
    }

    public String getUsername(){
        return user.getUsername();
    }

    public void onClickConnect(){
        Log.d(LoginViewModel.class.getSimpleName(), getUsername());
        User.MY_ID = this.user.getUsername();
        this.isLoginSuccess.setValue(true);
    }

    public LiveData<Boolean> isLoginSuccess() {
        return this.isLoginSuccess;
    }
}
