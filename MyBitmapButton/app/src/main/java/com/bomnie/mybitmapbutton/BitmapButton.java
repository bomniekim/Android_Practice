package com.bomnie.mybitmapbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

public class BitmapButton extends AppCompatButton {
    public BitmapButton(Context context) {
        super(context);

        init(context);
    }

    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        // 배경 이미지 설정하기
        setBackgroundResource(R.drawable.title_bitmap_button_normal );

        float textSize = getResources().getDimension(R.dimen.text_size);
        setTextSize(textSize);// 16dp 크기의 텍스트 설정

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();


        switch (action){
            case MotionEvent.ACTION_DOWN: // 눌렀을 때
                setBackgroundResource(R.drawable.title_bitmap_button_clicked);

                break;


            case MotionEvent.ACTION_UP: // 손가락을 뗐을 때
                setBackgroundResource(R.drawable.title_bitmap_button_normal);

                break;


        }

        invalidate(); // 화면을 갱신해달라 - 다시 그려달라는 의미
        // invalidate 함수가 호출되면 onDraw 함수가 호출되는데
        // 그 과정을 통해서 갱신된 정보를 가지고 다시 그려줌.

        return true;
    }
}
