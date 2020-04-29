package com.duyquangnvx.chat_with_stranger.View;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.duyquangnvx.chat_with_stranger.Utils.NetworkUtils;
import com.duyquangnvx.chat_with_stranger.viewmodel.BaseViewModel;

public abstract class BaseActivity <T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {
    private ProgressDialog mProgressDialog = null;
    private T mViewDataBinding;
    private V mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //isNetworkConnected = isNetworkConnected();
        performDataBinding();
    }

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }


    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    protected abstract @LayoutRes
    int getLayoutId();

    void showProgressLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading");
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.show();
    }

    void updateMessageProgressDialog(String message) {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.setMessage(message);
        }
    }

    void dismissProgressLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    /*void setOnNetworkActiveListener(ConnectivityManager.OnNetworkActiveListener onNetworkActiveListener) {
        this.onNetworkActiveListener = onNetworkActiveListener;
    }

    boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        this.isNetworkConnected = networkInfo != null && networkInfo.isConnected();

        return this.isNetworkConnected;
    }

    private void registerBroadcastReciver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        BroadcastReceiver receiver = new BroadcastReceiver(){
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action != null) {

                }


            }
        }
    }*/

}
