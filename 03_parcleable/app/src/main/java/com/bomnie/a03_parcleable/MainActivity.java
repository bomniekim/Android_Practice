package com.bomnie.a03_parcleable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                ArrayList<String> names = new ArrayList<String>();
                names.add("Son");
                names.add("Harry ");

                intent.putExtra("name", names);
                // 인텐트를 전달하면서 키 값과 객체이름을 같이 보냄

                SimpleData data = new SimpleData(77, "Hello");
                intent.putExtra("data", data);
                // 기본적으로 전달하는 데이터에는 객체를 넣을 수 없지만
                // parcelable 로 구현한 SimpleData 객체는 넣을 수 있음!
                startActivityForResult(intent,  101 );
            }
        });
    }
}
