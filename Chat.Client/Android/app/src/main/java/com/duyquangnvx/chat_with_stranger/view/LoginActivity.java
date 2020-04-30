package com.duyquangnvx.chat_with_stranger.view;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.duyquangnvx.chat_with_stranger.BR;
import com.duyquangnvx.chat_with_stranger.R;
import com.duyquangnvx.chat_with_stranger.viewmodel.LoginViewModel;
import com.duyquangnvx.chat_with_stranger.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {
    ActivityLoginBinding binding;
    LoginViewModel loginViewModel = new LoginViewModel();

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    public void loginSuccess() {
        loginViewModel.isLoginSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Intent intent = ChatActivity.getStartIntent(LoginActivity.this);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewDataBinding();
        loginSuccess();
    }

    @Override
    public LoginViewModel getViewModel() { return loginViewModel; }

    @Override
    public int getBindingVariable() {
        return BR.loginViewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }
}
