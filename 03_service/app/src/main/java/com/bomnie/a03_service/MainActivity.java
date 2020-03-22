package com.bomnie.a03_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                String name = editText.getText().toString();

                Intent intent= new Intent(getApplicationContext(), MyService.class);
                intent.putExtra("command", "show");
                intent.putExtra("name", name);
                // 부가 데이터로 두개의 값이 전달됨
                startService(intent); // 서비스를 시작
            }
        });

        Intent passedIntent = new Intent();
        processCommand(passedIntent);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        // MainActivity 가 이미 만들어 진 상황에서 onCreate()이 아니라
        // onNewIntent()가 호출됨

        processCommand(intent);
        super.onNewIntent(intent);
    }

    private void processCommand(Intent intent){
        if (intent !=null){
            String command =intent.getStringExtra("command");
            String name =intent.getStringExtra("name");

            Toast.makeText(this, "서비스로부터 전달받은 데이터: "+command+", "+name, Toast.LENGTH_LONG).show();
        }

    }
}
