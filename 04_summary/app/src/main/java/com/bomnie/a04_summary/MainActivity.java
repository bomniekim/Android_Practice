package com.bomnie.a04_summary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// 프래그먼트에서 액티비티 쪽으로 명령이나 데이터를 전달
public class MainActivity extends AppCompatActivity implements FragmentCallback {
    Fragment1 fragment1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(fragment1 !=null){
                     fragment1.onCommandFromActivity("show","액티비로부터 전달됨");
                 }
            }
        });

        fragment1 = new Fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();
    }

    public void onCommand(String command, String data){
        button.setText(data);

    }
}
