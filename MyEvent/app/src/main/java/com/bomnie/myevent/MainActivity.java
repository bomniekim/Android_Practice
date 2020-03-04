package com.bomnie.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

// commit -m : 터치 이벤트에 기반한 gesture 처리

public class MainActivity extends AppCompatActivity {



    TextView tv;


    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction(); // 각각의 상태를 구분할 수 있는 구분자

                float curX = event.getX();
                float curY = event.getY();
                // 손가락이 눌린 곳의 좌표



                if (action == MotionEvent.ACTION_DOWN){
                    // 손가락으로 눌렀을 때
                    println("touched : " + curX + ", " + curY );
                } else if(action == MotionEvent.ACTION_MOVE){
                    // 손가락을 누른 상태로 움직 때
                    println("moved : " + curX + ", " + curY );
                } else if (action == MotionEvent.ACTION_UP){
                    // 손가락을 뗐을 때
                    println("detached : " + curX + ", " + curY );
                }

                return true; // 이 이벤트가 정상적으로 처리된 것을 알려
            }
       });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                println("onDown() 호출됨");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                println("onShowPress() 호출됨");

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                println("onSingleTapUp() 호출됨");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                println("onScroll() 호출됨" + distanceX + ", "+ distanceY );
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                println("onLongPress() 호출됨");

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                println("onFling() 호출됨" + velocityX + ", "+ velocityY);
                return true;
            }

        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 키가 눌렸을 때 호출되는 메소드
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "Back Button Pressed", Toast.LENGTH_SHORT).show();

            return true;
            // 중간에서 가로채고 return true 를 했기 때문에 다른 처리를 할 수 없고 시스템 화면이 꺼지지 않음
            // ex) "한번 더 누르면 종료됩니다." 같은 이벤트를 만들 수 있음
        }

        return false;
    }

    public void println(String data){
        tv.append(data + "\n");
    }
}
