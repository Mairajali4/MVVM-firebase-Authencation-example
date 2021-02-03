package com.example.share.ui.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchViewModel extends ViewModel {
    private MutableLiveData<String> mtext;

    public SearchViewModel() {
        mtext=new MutableLiveData<>();
        mtext.setValue("This is serch fragment");
    }

    public LiveData<String> getText() {
        return mtext;
    }
}