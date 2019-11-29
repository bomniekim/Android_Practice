package com.bomnie.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() { // 상속은 :로 표시

    override fun onCreate(savedInstanceState: Bundle?) { // 변수명: 자료형
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickBtn(view: View) {
        // XML 에서 지정한 id를 곧바로 변수명으로 사용함
        tv.setText("Nice to meet you Kotlin!")
    }

    //onResume 메소드 오버라이드
    override fun onResume(){
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }
}
