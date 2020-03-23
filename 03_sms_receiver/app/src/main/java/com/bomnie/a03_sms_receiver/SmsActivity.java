 package com.bomnie.a03_sms_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

 public class SmsActivity extends AppCompatActivity {
    EditText number, contents, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        number = findViewById(R.id.number);
        contents = findViewById(R.id.content);
        date = findViewById(R.id.date);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 finish();
            }
        });

        Intent passedIntent = getIntent();
        processCommand(passedIntent);
    }

     @Override
     protected void onNewIntent(Intent intent) {
        processCommand(intent);

        super.onNewIntent(intent);
     }

     public void processCommand(Intent intent){

        if (intent != null){
            String sender =  intent.getStringExtra("sender");
            String content =  intent.getStringExtra("content");
            String receivedDate  =  intent.getStringExtra("receivedDate");

            number.setText(sender);
            contents.setText(content);
            date.setText(receivedDate);
        }
    }
}