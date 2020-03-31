package com.bomnie.a04_fragment2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    MainActivity activity;

    @Override
    public void onAttach(Context context) {
        // 액티비티에 올라와야 프래그먼트로써 동작
        super.onAttach(context);


        activity =  (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        activity = null; // 더 이상 참조하지 않음
    }

    // 프래그먼트의 시작 : setContentView 가 없기 때문에
    // onCreateView 오버라이딩해서 inflate 필요
    // onCreateView: inflate 되는 시점
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

         Button button = rootView.findViewById(R.id.button);
         // 프래그먼트 안에 들어있는 버튼
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // onAttach 에서 찾은 activity
                activity.onFragmentChange(1);
                // 액티비티에서 프래그먼트를 띄워줄 수 있도록
                // 메소드를 주고 받음
            }
        });


         getActivity();
         // 이 프래그먼트가 동작하는 액티비티를 참조
         // 프래그먼트는 부분화면이기 때문에 항상 액티비티 위에 올라가 있어야 함
         return rootView;
    }
}
