package com.bomnie.a04_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    // 프래그먼트의 시작 : setContentView 가 없기 때문에
    // onCreateView 오버라이딩해서 inflate 필요
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

         // 인플레이트한 rootView 를 리턴해주면 프래그먼트의 화면으로 보이게 됨
         // rootView : 이 프래그먼트 안에 들어가는 최상위 레이아웃
         return rootView;
    }
}
