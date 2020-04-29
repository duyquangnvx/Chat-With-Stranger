package com.duyquangnvx.chat_with_stranger.View;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.duyquangnvx.chat_with_stranger.BR;
import com.duyquangnvx.chat_with_stranger.R;
import com.duyquangnvx.chat_with_stranger.viewmodel.LoginViewModel;
import com.duyquangnvx.chat_with_stranger.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {
    ActivityLoginBinding mBinding;
    LoginViewModel mLoginViewModel = new LoginViewModel();

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public LoginViewModel getViewModel() { return mLoginViewModel; }

    @Override
    public int getBindingVariable() {
        return BR.loginViewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

}
