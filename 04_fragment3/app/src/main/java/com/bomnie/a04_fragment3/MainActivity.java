 package com.bomnie.a04_fragment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ListFragment fragment1;
    ViewerFragment fragment2;

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        fragment1 = (ListFragment) manager.findFragmentById(R.id.ListFragment);
        fragment2 = (ViewerFragment) manager.findFragmentById(R.id.ViewerFragment);
    }

    // 액티비티가 프래그먼트의 메소드를 호출해서 설정 - 직접 접근이 아님
    public void onImageChange(int index){
        fragment2.setImage(index);

    }
}

