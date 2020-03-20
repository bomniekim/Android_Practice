package com.bomnie.a03_call_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String receiver =editText.getText().toString();
                // 입력상자에 입력한 값을 가져오기
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+receiver));
                // "tel:" 을 인식하고 전화를 사용할 수 있는 앱을 자동으로 실행시켜 주는 것
                startActivity(intent);

                Intent intent1 = new Intent();
                ComponentName name = new ComponentName("com.bomnie.a03_call_intent", "com.bomnie.a03_call_intent.MenuActivity");
                intent1.setComponent(name); 
                startActivity(intent1);
            }
        });
    }
}

//인텐트의 액션과 데이터를 지정하긴 했지만, 호출할 대상이 달라질 수 있는 경우에는 암시적 인텐트를 사용

//즉 설치된 애플리케이션들에 대한 정보를 알고 있는 안드로이드 시스템이 인텐트를 이용해
// 요청한 정보를 처리할 수 있는 적절한 콤포넌트를 찾아본 다음 사용자에게 그 대상과 처리 결과를 보여주는 과정을 거치게

// 이미 기존에 어떤 기능들을 지원하는 앱들이 있는 경우에 암시적 인텐트를 사용해서 그 앱들을 사용