package com.bomnie.chattingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ChattingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<ChatData> chatList;
    private String nick = "nick1";

    private EditText et_chat;
    private Button btn_send;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        et_chat = findViewById(R.id.et_chat);
        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = et_chat.getText().toString();

                if( msg != null){
                    ChatData chat = new ChatData();
                    chat.setNickname(nick);
                    chat.setMsg(msg);
                    myRef.push().setValue(chat);
                    // caution!!
                    // 특정한 형태의 클래스를 여러 종류로 바꿔가며 넣다보면 값을 빼서 쓸 때 조심해야 함

                }
            }
        });

        // 리사이클러뷰 최초 세팅
        recyclerView = findViewById(R.id.chat_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // 어댑터 세팅
        chatList = new ArrayList<>();
        mAdapter = new ChatAdapter(chatList, ChattingActivity.this, nick);
        recyclerView.setAdapter(mAdapter);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        // 1. RecyclerView - 반복
        // 2. DB 내용 넣기
        // 3. 상대방 폰에 채팅 내용이 보임 -get


        // 1-1. recyclerView- chat data
        // 1. message, nickname, isMine - Data Transfer Object

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ChatData chat = dataSnapshot.getValue(ChatData.class); // 채팅 데이터를 가지고 오는 함수
                ((ChatAdapter) mAdapter).addChat(chat);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}

