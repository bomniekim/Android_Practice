package com.bomnie.practiceapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<NewsData> mDataset;
    private static View.OnClickListener onClickListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // 항목화면에 들어가는 뷰 하나하나 연결
        // card_news.xml 안의 하나하나의 뷰 연결 - 계속해서 재사용 가능
        // each data item is just a string in this case
        public TextView tv_title;
        public TextView tv_content;
        public SimpleDraweeView iv_title;
        public View rootView;

        public MyViewHolder(View v) { // v: card_news.xml 의 root
            super(v);
            // ViewHolder = 메모리 관리와 성능 향상을 위해 안드로이드에서 친절히 만들어준 클래스
            // card_news.xml의 자식요소들을 재사용할 수 있도록
            tv_title = v.findViewById(R.id.tv_title);
            tv_content = v.findViewById(R.id.tv_content);
            iv_title = v.findViewById(R.id.iv_title);
            rootView = v;

            v.setClickable(true); // card_news.xml(LinearLayout)을 클릭 가능하게끔
            v.setEnabled(true);
            v.setOnClickListener(onClickListener);
            // 카드 하나의 어느 곳을 누르더라도 본문 내용으로 넘어가게 하도록 v에 설정
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    // mDataset: 각 card_news 뷰마다 보여줄 값을 가지고 있는 초기 데이터 원본
    public MyAdapter(List<NewsData> myDataset, Context context, View.OnClickListener onClick) {
        mDataset = myDataset;
        onClickListener = onClick;
        Fresco.initialize(context);

        // context는 Activity에서 받아오는 것이기 때문에 단순한 class에서는 사용가
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
        NewsData news = mDataset.get(position);

        holder.tv_title.setText(news.getTitle());
        holder.tv_content.setText(news.getContent());

        Uri uri = Uri.parse(news.getUrlToImage());
        holder.iv_title.setImageURI(uri);

        // 여기에 클릭이벤트를 달면 갱신될 때마다 클릭이벤트를 생성하기 때문에 비효율적
        // tag - label
        holder.rootView.setTag(position); // v에 태그를 다는 작업

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }

    public NewsData getNews(int position){
        return mDataset != null ? mDataset.get(position) : null ;
    }
}
