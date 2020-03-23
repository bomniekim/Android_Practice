package com.bomnie.a03_summary_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);

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
}
