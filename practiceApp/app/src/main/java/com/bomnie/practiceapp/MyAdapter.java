package com.bomnie.practiceapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // 항목화면에 들어가는 뷰 하나하나 연결
        // card_news.xml 안의 하나하나의 뷰 연결 - 계속해서 재사용 가능
        // each data item is just a string in this case
        public TextView tv_title;
        public TextView tv_content;
        public ImageView iv_title;

        public MyViewHolder(View v) {
            super(v);
            // card_news.xml의 자식요소들을 재사용할 수 있도록
            tv_title = v.findViewById(R.id.tv_title);
            tv_content = v.findViewById(R.id.tv_content);
            iv_title = v.findViewById(R.id.iv_title);
            // ViewHolder = 메모리 관리와 성능 향상을 위해 안드로이드에서 친절히 만들어준 클래스
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    // mDataset: 각 card_news 뷰마다 보여줄 값을 가지고 있는 초기 데이터 원본
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        // 리사이클러 뷰의 항목화면 전체 연결
        // card_news.xml 전체 파일 연결
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_news, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tv_title.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
