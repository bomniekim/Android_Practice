package com.bomnie.kotlinrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

//        val intent = getIntent()

        val title= intent.getStringExtra("title")
        val msg= intent.getStringExtra("msg")
        val img= intent.getIntExtra("img",0)

        supportActionBar!!.title= title
        tv.text= msg

        if(img!=0) Glide.with(this).load(img).into(iv)


    }
}
