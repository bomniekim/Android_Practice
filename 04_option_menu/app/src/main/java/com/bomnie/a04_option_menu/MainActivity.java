package com.bomnie.a04_option_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ActionBar actionBar= getSupportActionBar();
//        actionBar.hide();
        // 기본 스타일을 무시하고 숨김 가능
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // 옵션 메뉴가 선택되었을 때 호출되는 메소드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // item: 선택된 메뉴 아이템
        int curId = item.getItemId();
        switch (curId){
            case R.id.menu_refresh:
                Toast.makeText(this, "새로고침 메뉴 클릭됨", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_search:
                Toast.makeText(this, "검색 메뉴 클릭됨", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_settings:
                Toast.makeText(this, "설정 메뉴 클릭됨", Toast.LENGTH_SHORT).show();
                break;

                default:
                    break;
        }



        return super.onOptionsItemSelected(item);
    }
}
