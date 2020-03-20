package com.bomnie.a03_activity_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 콜백메소드: 시스템 쪽에서 자동으로 상태나 시점에 맞추어 호출
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate() 호출됨", Toast.LENGTH_SHORT).show();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "onStart() 호출됨", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        // 화면이 포커스를 잃을때 (일시정지)
        super.onPause();

        Toast.makeText(this, "onPause() 호출됨", Toast.LENGTH_SHORT).show();

        // SharedPreferences : 간단한 데이터 저장
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        // name: 저장할 때와 복구할 때 동일하게
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name","COYS"); // put으로 데이터 집어넣기
        editor.commit();
    }

    @Override
    protected void onResume() {
        // 화면이 시작될때 와 화면이 중지된 후 다시 시작할 때
        super.onResume();

        Toast.makeText(this, "onResume() 호출됨", Toast.LENGTH_SHORT).show();

        // 복구하기
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if (pref !=null){
            String name= pref.getString("name",""); // get으로 데이터 빼내기
            // defValue: name 값이 없는 경우 리턴되는 값

            Toast.makeText(getApplicationContext(), "복구된 이름:"+name, Toast.LENGTH_SHORT).show();


        }

    }

    @Override
    protected void onStop() {
        // 중지된 경우
        super.onStop();

        Toast.makeText(this, "onStop() 호출됨", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        // 메모리에서 리소스가 전부 사라짐
        super.onDestroy();

        Toast.makeText(this, "onDestroy() 호출됨", Toast.LENGTH_SHORT).show();
    }
}
