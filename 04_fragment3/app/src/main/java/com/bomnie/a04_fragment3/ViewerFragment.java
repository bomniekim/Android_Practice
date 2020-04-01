package com.bomnie.a04_fragment3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewerFragment extends Fragment {

    ImageView iv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer, container, false);

         iv = rootView.findViewById(R.id.iv_1);
         return rootView;

    }

    public void setImage(int index){
        if (index == 0){
            iv.setImageResource(R.drawable.mimo1);
        }else if(index == 1){
            iv.setImageResource(R.drawable.mimo2);
        }else if(index == 2){
            iv.setImageResource(R.drawable.mimo3);
        }
    }
}
