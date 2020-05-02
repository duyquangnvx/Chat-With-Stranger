package com.duyquangnvx.chat_with_stranger.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.duyquangnvx.chat_with_stranger.R;
import com.duyquangnvx.chat_with_stranger.adapter.MessageAdapter;
import com.duyquangnvx.chat_with_stranger.databinding.ActivityChatBinding;
import com.duyquangnvx.chat_with_stranger.viewmodel.ChatViewModel;

public class ChatActivity extends BaseActivity<ActivityChatBinding, ChatViewModel> {
    ActivityChatBinding dataBinding;
    ChatViewModel chatViewModel = new ChatViewModel();
    MessageAdapter adapter = null;

    private void initAdapter() {
        adapter = new MessageAdapter(chatViewModel.getMessages());
        LinearLayoutManager manager = new LinearLayoutManager(ChatActivity.this, RecyclerView.VERTICAL, false);
        dataBinding.rvMessages.setLayoutManager(manager);
        dataBinding.rvMessages.setAdapter(adapter);

        chatViewModel.isReceived().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    adapter.notifyDataSetChanged();
                    dataBinding.edtContent.setText("");
                }
            }
        });;
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ChatActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = getViewDataBinding();

        initAdapter();
    }

    @Override
    public ChatViewModel getViewModel() {
        return this.chatViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.chatViewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chat;
    }
}
