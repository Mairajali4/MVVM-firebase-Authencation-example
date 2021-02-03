package com.example.share.ui.camera;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CameraViewModel extends ViewModel {
    private MutableLiveData<String> mtext;
    public CameraViewModel(){
        mtext=new MutableLiveData<>();
        mtext.setValue("this is ca,mera");
    }
    public LiveData<String> getText(){
        return mtext;
    }
}