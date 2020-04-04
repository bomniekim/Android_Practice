package com.bomnie.a04_summary;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    FragmentCallback callback;
    TextView textView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        // 인터페이스를 이용하기 위해서 context
        // 특정 액티비티를 get 했던 기존의 방식과 다름
        if (context instanceof FragmentCallback){
            callback = (FragmentCallback) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if (callback !=null){
            callback =null; // 개념적으로
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        textView = rootView.findViewById(R.id.text);

        Button button = rootView.findViewById(R.id.button2);
         button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null){
                    // 액티비티 위에 올라간 상태
                    callback.onCommand("show", "Fragment1에서 전달함");
                }

            }
        });
       return rootView;
    }

    public void onCommandFromActivity(String command, String data){
        textView.setText(data);
    }
}
