package com.bomnie.a04_fragment2;


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

                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                // replace : 기존에 있는 것을 대체
            }
        });

        Button menu = findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
            }
        });


    }

    public void onFragmentChange(int index){

        // 액티비티에서 해당 프래그먼트를 띄워줌
        // 프래그먼트와 프래그먼트 간에 직접 접근하지 않음
        if(index == 0){
             getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
        }else if(index == 1){
             getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2 ).commit();

        }

    }
}
