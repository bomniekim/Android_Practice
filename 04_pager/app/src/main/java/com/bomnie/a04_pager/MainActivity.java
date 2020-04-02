package com.bomnie.a04_pager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        // 캐싱을 해 놓을 아이템의 최대 개수 지정
        // 기본은 3개보다 적게 되어 있음
        pager. setOffscreenPageLimit(3);
        // 프래그먼트를 3개까지 담아두고 스크롤 할 때 보여줌

        MoviePagerAdapter adapter = new MoviePagerAdapter(getSupportFragmentManager());


        Fragment1 fragment1 = new Fragment1();
        adapter.addItem(fragment1);
        Fragment2 fragment2 = new Fragment2();
        adapter.addItem(fragment2);
        Fragment3 fragment3 = new Fragment3();
        adapter.addItem(fragment3);

        pager.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(1); // 두번째 아이템 지정

            }
        });
    }

    // 뷰페이저에 설정할 어댑터
    // 각각의 아이템을 데이터로 관리
    class MoviePagerAdapter extends FragmentStatePagerAdapter{
        // 프래그먼트를 아이템으로 사용할 경우 이 클래스를 사용하는 경우가 많음

        ArrayList<Fragment> items = new ArrayList<Fragment>();
        // 프래그먼트가 하나의 데이터처럼 아이템으로 들어가 있음

        public MoviePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item); // 프래그먼트 추가
        }

        @Override
        public Fragment getItem(int position) {
            // 아이템 객체를 리턴
            return items.get(position);
        }

        @Override
        public int getCount() {
            // 어댑터 안에 들어있는 아이템의 개수
            return items.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            // 각 아이템마다 어떤 타이틀을 줄 것인지
            return "페이지 "+position;
        }
    }
}

// 프래그먼트는 항상 액티비티 위에서 움직이게 코딩해야 함!
