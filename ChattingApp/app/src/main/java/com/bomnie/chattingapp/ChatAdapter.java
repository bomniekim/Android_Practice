package com.bomnie.chattingapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private List<ChatData> mDataset;
    private String myNickname;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // 항목화면에 들어가는 뷰 하나하나 연결
        // card_news.xml 안의 하나하나의 뷰 연결 - 계속해서 재사용 가능
        // each data item is just a string in this case
        public TextView tv_nickname;
        public TextView tv_msg;
        public View rootView;

        public MyViewHolder(View v) { // v: card_news.xml 의 root
            super(v);
            // ViewHolder = 메모리 관리와 성능 향상을 위해 안드로이드에서 친절히 만들어준 클래스
            // card_news.xml의 자식요소들을 재사용할 수 있도록
            tv_nickname = v.findViewById(R.id.tv_nickname);
            tv_msg = v.findViewById(R.id.tv_msg);
            rootView = v;

            v.setClickable(true); // card_news.xml(LinearLayout)을 클릭 가능하게끔
            v.setEnabled(true);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    // mDataset: 각 card_news 뷰마다 보여줄 값을 가지고 있는 초기 데이터 원본
    public ChatAdapter(List<ChatData> myDataset, Context context, String myNickname) {
        mDataset = myDataset;
        this.myNickname = myNickname;

        // context는 Activity에서 받아오는 것이기 때문에 단순한 class에서는 사용가
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ChatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        // 리사이클러 뷰의 항목화면 전체 연결
        // card_news.xml 전체 파일 연결
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_chat, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ChatData chat = mDataset.get(position);

        holder.tv_msg.setText(chat.getMsg());
        holder.tv_nickname.setText(chat.getNickname());

        // 닉네임을 비교하여 메세지 정렬
        if(chat.getNickname().equals(this.myNickname)){
            holder.tv_msg.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            holder.tv_nickname.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
        }else{
            holder.tv_msg.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
            holder.tv_nickname.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);

        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }

    public ChatData getChat(int position){
        return mDataset != null ? mDataset.get(position) : null ;
    }

    // 채팅은 메세지가 들어올 때마다 덧붙여야 하는 로직 필요
    public void addChat(ChatData chat){
        mDataset.add(chat);
        notifyItemInserted(mDataset.size()-1); // add하면 채팅 데이 배열의 크기가 늘어나므로 그것을 활용/ 리사이클러뷰 갱신용
    }
}
