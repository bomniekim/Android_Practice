package com.bomnie.practiceapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] mDataset = {"Sonny","Harry"};

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.recycler);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        // 1. 화면이 로딩 -> 뉴스 정보를 받아온다
        // 2. 정보 -> 어댑터에 넘겨준다
        // 3. 어댑터 -> setting

        queue = Volley.newRequestQueue(this);
        getNews();

    }

    public void getNews(){

        String url ="http://newsapi.org/v2/top-headlines?country=kr&apiKey=22416fa99769434b8150ca5106199bc8";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //Log.d("NEWS", response);

                        try {
                            // String인 response를 JSON으로 바꾸어주는 작업
                            JSONObject jsonObj = new JSONObject(response);

                            // 만들어진 JSON 객체에서 하나씩 빼오는 작업
                            JSONArray arrayArticles = jsonObj.getJSONArray("articles");

                            // response ->> NewsData class에서 분류!
                            // NewsData를 여러 개 가질 수 있는 ArrayList 필요
                            List<NewsData> news= new ArrayList<>();

                            for(int i=0, j=arrayArticles.length(); i<j; i++){
                                JSONObject obj = arrayArticles.getJSONObject(i);

                                Log.d("NEWS", obj.toString());
//
//                                obj.getString("title");
//                                obj.getString("urlToImage");
//                                obj.getString("content");
                                // 키 값이 아닌 밸류 값이 String인 데이터를 가져온다는 의미

                                NewsData newsData = new NewsData();
                                newsData.setTitle(obj.getString("title"));
                                newsData.setUrlToImage(obj.getString("urlToImage"));
                                newsData.setContent(obj.getString("description"));

                                news.add(newsData);
                            }



                            // specify an adapter (see also next example)
                            // 정보를 어댑터로 넘겨주는 코드
                            mAdapter = new MyAdapter(news, NewsActivity.this, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Object obj = v.getTag();
                                    if(obj !=null ){
                                        int position = (int)obj;
                                        ((MyAdapter)mAdapter).getNews(position);
                                        Intent intent = new Intent(NewsActivity.this, NewsDetailActivity.class);
                                        intent.putExtra("news", ((MyAdapter)mAdapter).getNews(position));
                                        startActivity(intent);
                                        // 1. 본문
                                        // 2. 전체
                                            // 2-1. 하나씩
                                            // 2-2. 한번에 class 전
                                        startActivity(intent);
                                    }
                                }
                            }); // 어댑터에 context를 넘겨주기 위해 파라미터로..
                            recyclerView.setAdapter(mAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}
