package com.bomnie.chattingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChattingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        // 1. RecyclerView - 반복
        // 2. 디비 내용 넣기
        // 3. 상대방 폰에 채팅 내용이 보임 -get


        // 1-1. recyclerView- chat data
        // 1. message, nickname, isMine - Data Transfer Object




    }
}

