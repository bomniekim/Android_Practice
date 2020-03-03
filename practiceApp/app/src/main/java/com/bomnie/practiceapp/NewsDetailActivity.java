package com.bomnie.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NewsDetailActivity extends AppCompatActivity {

    private NewsData news;
    private TextView tv_title, tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        tv_title = findViewById(R.id.tv_title);
        tv_content = findViewById(R.id.tv_content);

        getNewsDetail();
        setNews();
    }

    //이전 액티비티에서 받아오는 인텐트
    public void getNewsDetail() {
        Intent intent = getIntent();
        if(intent != null) {
            Bundle bld = intent.getExtras();

            Object obj = bld.get("news");
            if(obj != null && obj instanceof NewsData) {
                this.news = (NewsData) obj;
            }
        }
    }

    //이전 액티비티에서 받아오는 인텐트에서 정보를 확인하여 뉴스표시
    public void setNews() {
        if(this.news != null) {
            String title = this.news.getTitle();
            if(title != null) {
                tv_title.setText(title);
            }
            String content = this.news.getContent();
            if(content != null) {
                //전체 본문은 url 값의 실제 뉴스 사이트에 있으며, 해당 전체 본문을 불러오기 위해서는 스크래핑 (크롤링) 기술로 읽어와야 합니다.
                tv_content.setText(content);
            }

        }
    }
}