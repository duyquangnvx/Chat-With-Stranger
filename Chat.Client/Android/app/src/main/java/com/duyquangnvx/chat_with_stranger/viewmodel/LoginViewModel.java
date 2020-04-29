package com.duyquangnvx.chat_with_stranger.viewmodel;

import android.util.Log;

import androidx.databinding.Bindable;

import com.duyquangnvx.chat_with_stranger.Model.User;

public class LoginViewModel extends BaseViewModel {
    public User user;

    public LoginViewModel() {
        this.user = new User();
    }

    public void onClickConnect(){
        Log.d(LoginViewModel.class.getSimpleName(), getUsername());
    }

    public void setUsername(String username){
        user.setUsername(username);
    }

    public String getUsername(){
        return user.getUsername();
    }
}
