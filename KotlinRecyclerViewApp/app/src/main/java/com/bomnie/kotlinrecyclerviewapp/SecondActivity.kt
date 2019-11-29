package com.bomnie.kotlinrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    // 대량의 데이터 멤버변수[property]
    var items= ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 연습 : 대량의 데이터 추가
        items.add(Item("Sam", "Hello Kotlin", R.drawable.moana01))
        items.add(Item("Bam", "Nice Kotlin", R.drawable.moana02))
        items.add(Item("Cam", "Good Kotlin", R.drawable.moana03))
        items.add(Item("Dam", "Cute Kotlin", R.drawable.moana04))
        items.add(Item("Fam", "Handsome Kotlin", R.drawable.moana05))
        items.add(Item("Gam", "Glorious Kotlin", R.drawable.battle1))
        items.add(Item("Ham", "Humorous Kotlin", R.drawable.battle2))
        items.add(Item("Iam", "Gorgeous Kotlin", R.drawable.battle3))
        items.add(Item("Jam", "Lovely Kotlin", R.drawable.battle4))

        // 리사이클러 뷰 안에 이미 adpater property(멤버변수)가 존재
        // 그래서 별도의 멤버변수가 필요하지 않고
        // 리사이클러 뷰도 id가 이미 변수로 되어 있기에 리사이클러 참조변수도 별도로 만들 필요가 없음
        recycler.adapter= MyAdapter(this, items)

        // LayoutManager 붙이기
        recycler.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onResume() {
        super.onResume()

        // 리사이클러 뷰 갱신해보기
        recycler.adapter!!.notifyDataSetChanged() // [!! 는 자바의 !=null 와 같은 의미 : null 이 아닐 때만 동작해라] - 훨씬 안전 
    }
}
