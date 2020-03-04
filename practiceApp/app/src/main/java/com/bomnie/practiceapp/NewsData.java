package com.bomnie.practiceapp;

// JSON에서 필요한 값만 효율적으로 넣고 빼고 할 수 있는 클래스

import java.io.Serializable;

public class NewsData implements Serializable { // 직렬화

    // 데이터 캡슐화
    // 다른 클래스에서 직접 접근해서 데이터를 변경하는 것을 막기 위해 private
    private String title;
    private String urlToImage;
    private String content;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
