package com.duyquangnvx.chat_with_stranger.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.duyquangnvx.chat_with_stranger.viewholder.BaseViewHolder;

import java.util.ArrayList;

public abstract class BaseAdapter <T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    private ArrayList<T> items;

    public BaseAdapter(ArrayList<T> data) {
        this.items = data;
    }

    public T getItem(int position) {return  items == null? null : items.get(position);}

    public ArrayList<T> getItems() {return items;}

    abstract void setData(VH holder, T data);

    abstract VH getViewHolder(LayoutInflater inflater, ViewGroup parent);

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return getViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        final T item = this.items.get(position);
        setData(holder, item);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}
