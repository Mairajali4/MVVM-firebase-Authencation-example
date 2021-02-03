package com.example.share.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {
   private MutableLiveData<String> mtext;
   public ProfileViewModel(){
       mtext=new MutableLiveData<>();
       mtext.setValue("this is peofile fragment");
   }
   public LiveData<String> getText(){
       return mtext;
   }
}