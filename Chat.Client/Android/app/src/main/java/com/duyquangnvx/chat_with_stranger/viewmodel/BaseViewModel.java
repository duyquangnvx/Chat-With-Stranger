package com.duyquangnvx.chat_with_stranger.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    private MutableLiveData<Boolean> isShowProgress;
    private String progressMessage;

    BaseViewModel() {
        this.isShowProgress = new MutableLiveData<>();
        this.isShowProgress.setValue(false);
    }

    public LiveData<Boolean> isShowProgress() {
        return this.isShowProgress;
    }

    void setIsShowProgress(boolean isShow) {
        this.isShowProgress.postValue(isShow);
    }

    void setIsShowProgress(boolean isShow, String message) {
        this.progressMessage = message;
        this.isShowProgress.postValue(isShow);
    }

    public String getProgressMessage() {
        return this.progressMessage;
    }

    void setProgressMessage(String message) {
        this.progressMessage = message;
    }
}
