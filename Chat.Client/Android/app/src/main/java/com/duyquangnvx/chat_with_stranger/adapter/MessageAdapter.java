package com.duyquangnvx.chat_with_stranger.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.duyquangnvx.chat_with_stranger.databinding.LayoutReceiveMessageBinding;
import com.duyquangnvx.chat_with_stranger.databinding.LayoutSendMessageBinding;
import com.duyquangnvx.chat_with_stranger.model.Message;
import com.duyquangnvx.chat_with_stranger.model.User;
import com.duyquangnvx.chat_with_stranger.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends BaseAdapter<Message, BaseViewHolder> {
    private static int SEND_TYPE = 1;
    private static int RECEIVE_TYPE = 2;

    public MessageAdapter(ArrayList<Message> data) {
        super(data);
    }

    public MessageAdapter(List<Message> data) {
        super(data);
    }

    @Override
    void setData(BaseViewHolder holder, Message data) {
        if (holder instanceof SendMessageViewHolder) {
            ((SendMessageViewHolder) holder).getDataBinding().setMessage(data);
        } else {
            ((ReceiveMessageViewHolder) holder).getDataBinding().setMessage(data);
        }
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == SEND_TYPE) {
            return new SendMessageViewHolder(LayoutSendMessageBinding.inflate(inflater, parent, false));
        } else {
            return new ReceiveMessageViewHolder(LayoutReceiveMessageBinding.inflate(inflater, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return this.getItem(position).getSender().isMe() ? SEND_TYPE : RECEIVE_TYPE;
    }

    @Override
    BaseViewHolder<ViewDataBinding> getViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return null;  // Không cần dùng trong trường hợp này
    }

    public class ReceiveMessageViewHolder extends BaseViewHolder<LayoutReceiveMessageBinding> {
        ReceiveMessageViewHolder(@NonNull LayoutReceiveMessageBinding dataBinding) {
            super(dataBinding);
        }
    }

    public class SendMessageViewHolder extends BaseViewHolder<LayoutSendMessageBinding> {
        SendMessageViewHolder(@NonNull LayoutSendMessageBinding dataBinding) {
            super(dataBinding);
        }
    }
}
