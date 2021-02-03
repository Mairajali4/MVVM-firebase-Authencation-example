package com.example.share.ui.camera;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.share.R;

public class Camera extends Fragment {

    private CameraViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       mViewModel=ViewModelProviders.of(this).get(CameraViewModel.class);
       View root=inflater.inflate(R.layout.camera_fragment,container,false);
       final TextView textView=root.findViewById(R.id.text_camera);
       mViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
           @Override
           public void onChanged(String s) {
               textView.setText(s);
           }
       });
       return root;
    }
}