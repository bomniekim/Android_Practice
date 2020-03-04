package com.bomnie.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText et_email, et_password;
    RelativeLayout relative_login;

    String emailOk="1234@gmail.com";
    String passwordOk="1234";

    String inputEmail="";
    String inputPassword="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        relative_login= findViewById(R.id.relative_login);

        // 1. 값을 가져온다 - 검사 (1234@gmail.com / 1234 ) 로직 만들
        // 2. 클릭을 감지한다
        // 3. 1번의 값을 다음 액티비티로 넘긴다기

        relative_login.setClickable(false);
        // 처음에는 누를 수 없지만 값을 검사했을 때 통과하면 클릭 가능하도록
        et_email.addTextChangedListener(new TextWatcher() {
            // 입력되는 텍스트에 변화가 있을 때 마다 리스너 이벤트가 작동
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("bomin", s + ","+ count);
                if ( s != null){
                    // toString은 값이 null이 아닐 때만 반환하도록
                    inputEmail = s.toString();
                    if(validation()){
                        relative_login.setClickable(true);
                    }else {
                        relative_login.setClickable(false);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("bomin", s + ","+ count);
                if ( s != null){
                    // toString은 값이 null이 아닐 때만 반환하도록
                    inputPassword = s.toString();
                    if(validation()){
                        relative_login.setClickable(true);
                    }else {
                        relative_login.setClickable(false);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        relative_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭 시 값을 가져오는 동작 수행
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();

                // 다른 Activity로 넘어가는 동작 수행
                Intent intent= new Intent(LoginActivity.this, LoginResultActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });

    }

    public boolean validation(){
//        return inputEmail == emailOk && inputPassword == passwordOk;
        // String은 같은 지 비교할 때 == 쓰면 안되자나!
        // .equal를 써야돼!

        // 디버깅
        Log.d("bomin", inputEmail + " / " + inputPassword + " / " + (inputEmail.equals(emailOk)) + " / " + (inputPassword.equals(passwordOk)));
        return inputEmail.equals(emailOk) && inputPassword.equals(passwordOk);
    }
}
