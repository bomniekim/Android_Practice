package com.bomnie.a04_fragment3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    MainActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

         Button btn1 = rootView.findViewById(R.id.btn1);
         btn1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                activity.onImageChange(0);
             }
         });

         Button btn2 = rootView.findViewById(R.id.btn2);
         btn2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                activity.onImageChange(1);

             }
         });

         Button btn3 = rootView.findViewById(R.id.btn3);
         btn3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                activity.onImageChange(2);

             }
         });
         return rootView;

    }
}
