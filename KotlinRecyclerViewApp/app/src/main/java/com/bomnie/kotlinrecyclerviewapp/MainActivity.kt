package com.bomnie.kotlinrecyclerviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 멤버 변수를 만들 필요 없이
        // id가 btn 인 버튼에 클릭리스너 추가하기
        // [코틀린은 id가 참조변수!]
        btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                //SecondActivity 를 실행해주는 Intent 객체 생성
                var intent= Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }
        })


    }

    fun clickExit(view: View) {
        finish() // 액티비티 종료
    }
}
