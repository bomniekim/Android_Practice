package com.bomnie.a03_parcleable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 이전에 쌓여있던 메인 액티비티 화면이 보여짐(스택구조)
            }
        });

        Intent passedIntent = getIntent();
        // MainActivity 에서 전달된 인텐트가 오는 것
        // Extra data는 시스템에서 건들이지 않고 바로 전달되어 옴
        processIntent(passedIntent);
    }

    private void processIntent(Intent intent){
         if( intent != null){
             ArrayList<String> names = (ArrayList<String>)intent.getSerializableExtra("name");
             // put으로 넣은 데이터를 get으로 빼내오기
             // 인텐트를 ArrayList<String>로 캐스팅
             if(names != null){
                 Toast.makeText(getApplicationContext(), "전달받은 names 데이터의 개수:"+names.size(), Toast.LENGTH_SHORT).show();
             }

             SimpleData data = (SimpleData) intent.getParcelableExtra("data");
             if(data != null){
                 Toast.makeText(getApplicationContext(), "전달받은 SimpleData:"+data.msg, Toast.LENGTH_SHORT).show();
             }
         }

    }
}


