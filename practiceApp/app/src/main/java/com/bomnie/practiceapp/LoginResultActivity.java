package com.bomnie.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity {

    TextView tv_get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        tv_get= findViewById(R.id.tv_get);

        Intent intent= getIntent();

        Bundle bundle = intent.getExtras();
        // Extra에 email과 password를 넣었으니깐 일단 가져온 후 bundle로 설정
        // bundle에서 입력한 키 값으로 하나씩 꺼내오자
        String email = bundle.getString("email");
        String password= bundle.getString("password");

        tv_get.setText(email + " / " +password);



    }
}
