package com.bomnie.cinemaparadiso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView like;
    private ImageView unlike;
    private TextView likeView;
    private TextView unlikeView;

    private int likeCount;
    private int unlikeCount;
    private boolean likeState = false;
    private boolean unlikeState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        like = findViewById(R.id.like);
        unlike= findViewById(R.id.unlike);
        likeView= findViewById(R.id.likeView);
        unlikeView = findViewById(R.id.unlikeView);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeState){
                    likeCount--;
                    decLikeCount();
                }else{
                    likeCount++;
                    incLikeCount();
                }
            }
        });

        unlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(unlikeState){
                    unlikeCount--;
                    decUnLikeCount();
                }else{
                    unlikeCount++;
                    incUnLikeCount();
                }
            }
        });
    }

    public void decLikeCount(){
        likeView.setText(String.valueOf(likeCount));
        like.setPressed(false);
        like.setImageResource(R.drawable.thumbs_up_selector);
    }

    public void incLikeCount(){
        likeView.setText(String.valueOf(likeCount));
        like.setPressed(true);
        like.setBackgroundResource(R.drawable.thumbs_up_selector);
    }

    public void decUnLikeCount() {
        unlikeView.setText(String.valueOf(unlikeCount));
        unlike.setPressed(false);
        unlike.setBackgroundResource(R.drawable.thumbs_down_selector);
    }
    public void incUnLikeCount() {
        unlikeView.setText(String.valueOf(unlikeCount));
        unlike.setPressed(true);
        unlike.setBackgroundResource(R.drawable.thumbs_down_selector);
    }
}

