package com.bomnie.a04_tab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Fragment fragment1;
    Fragment fragment2;
    Fragment fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // xml 레이아웃으로 만든 툴바를 액션바로 설정하는 코드

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        // 소스 코드에서 프래그먼트를 보여주려면 FragmentManager 를 통해서

        // 1번 화면 띄우기
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();


        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("친구"));
        tabs.addTab(tabs.newTab().setText("채팅"));
        tabs.addTab(tabs.newTab().setText("설정 "));


        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition(); // 몇번째 탭인지 index 값으로

                Fragment selected = null;
                if(position == 0) {
                    selected = fragment1;
                }else if(position == 1){
                    selected = fragment2;
                }else if(position == 2) {
                    selected = fragment3;
                }

                // 선택된 프래그먼트를 화면에 보여주는 것은 FragmentManager가 담당

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });
    }
}
