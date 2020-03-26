package com.bomnie.a03_summary_;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView outputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        outputView= findViewById(R.id.outputView);

        Button button = findViewById(R.id.buttonWrite);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentWriteActivity();

            }
        });
    }

    public void showCommentWriteActivity(){

        // ratingBar 의 값을 가져오기 위해서
        float rating = ratingBar.getRating();
        Intent intent = new Intent(this, CommentWriteActivity.class);
        intent.putExtra("rating", rating);
        startActivityForResult(intent, 101 );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        // 새로 띄운 화면에서 응답을 받을 때 자동으로 호출
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == 101 ){
            if(intent != null){
                String contents= intent.getStringExtra("contents");
                // contents 라는 이름의 부가 데이터를 전달 받음
                outputView.setText(contents);

            }
        }
    }
}
