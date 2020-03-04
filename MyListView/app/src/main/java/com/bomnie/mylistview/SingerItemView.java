package com.bomnie.mylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SingerItemView extends LinearLayout {

    TextView tvName;
    TextView tvMobile;
    ImageView imageView;

    public SingerItemView(Context context) {
        super(context);

        init(context);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.singer_item, this, true);

        tvName = findViewById(R.id.tv_name);
        tvMobile = findViewById(R.id.tv_mobile);
        imageView = findViewById(R.id.iv);
    }

    public void setName(String name) {
        tvName.setText(name);
    }

    public void setMobile(String mobile) {
        tvMobile.setText(mobile);
    }

    public void setImageView(int resId){
        imageView.setImageResource(resId);
    }
}