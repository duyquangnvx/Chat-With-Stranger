package com.duyquangnvx.chat_with_stranger.viewholder;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder <T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T dataBinding;

    public BaseViewHolder(@NonNull T dataBinding) {
        super(dataBinding.getRoot());
        this.dataBinding = dataBinding;
    }

    public T getDataBinding(){
        return this.dataBinding;
    }
}
