package com.bomnie.a04_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MainFragment fragment1;
    MenuFragment fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new MainFragment();
        fragment2 = new MenuFragment();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 자바 소스 코드에서 프래그먼트를 직접 추가하는 방법
//                getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();
                // 프래그먼트 매니저에게 transaction 시작하게 하고 add 하는 방법
                // 프래그먼트 매니저가 프래그먼트를 담당

                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                // replace : 기존에 있는 것을 대체
            }
        });

        Button menu = findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getSupportFragmentManager().beginTransaction().add(R.id.container, fragment2).commit();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
            }
        });
    }

}
