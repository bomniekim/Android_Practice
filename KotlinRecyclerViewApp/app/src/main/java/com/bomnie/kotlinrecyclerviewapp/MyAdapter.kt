package com.bomnie.kotlinrecyclerviewapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import kotlinx.android.synthetic.main.recycler_item.view.*

class MyAdapter constructor(var context: Context, var items: ArrayList<Item>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater= LayoutInflater.from(context)
        val itemView= inflater.inflate(R.layout.recycler_item, parent, false)
        val vh= VH(itemView)

        return vh
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val vh = holder as VH // 코틀린에서의 다운캐스팅 방법

        val item = items.get(position)
//        vh.tvTitle.setText(item.title) // 코틀린에서는 getter, setter 메소드를 권장하지 않음
        vh.tvTitle.text = item.title // text 를 멤버변수로 사용
        vh.tvMsg.text = item.msg

        // Glide 라이브러리 사용하여 이미지 설정 - 자바 코드와 동일
        Glide.with(context).load(item.img).into(vh.iv)

        // getLayoutPosition()을 사용할 수 없어서 여기에 클릭리스너를 추가
        vh.itemView.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent= Intent(context, ItemActivity::class.java)
                intent.putExtra("title",item.title)
                intent.putExtra("msg",item.msg)
                intent.putExtra("image",item.img)

                context.startActivity(intent)
            }
        )


    // ViewHolder 클래스 (inner 클래스로 만들기)
    inner class VH constructor(itemView: View): RecyclerView.ViewHolder(itemView) {
        // 멤버변수[property]
        var tvTitle: TextView = itemView.tvTitle
        var tvMsg: TextView = itemView.tvMsg
        var iv: ImageView = itemView.iv
//        init{
//            tvTitle=itemView.findViewById(R.id.tvTitle)
//        }
    }
        init {
            // 자바에서는 이 곳에서 아이템 뷰 클릭 이벤트 처리를 했었음
            // 코틀린에서는 getLayoutPosition() 메소드의 결과가 언제나  -1만 나옴. 즉 포지션을 알 수 없음

            // 클릭리스너를 붙이는 작업을 onBindViewHolder()에서 작성
        }

    }
    }
}