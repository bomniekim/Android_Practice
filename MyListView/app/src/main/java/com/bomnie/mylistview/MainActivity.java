package com.bomnie.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    SingerAdapter adapter;

    EditText etName;
    EditText etMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etMobile = findViewById(R.id.et_mobile);


        listView = findViewById(R.id.listview);

        adapter = new SingerAdapter();
        adapter.additem(new SingerItem("소녀시대","010-1000-1000", R.drawable.icon01));
        adapter.additem(new SingerItem("레드벨벳","010-2000-1000", R.drawable.icon02));
        adapter.additem(new SingerItem("블랙핑크","010-3000-1000", R.drawable.icon03));
        adapter.additem(new SingerItem("우주소녀","010-4000-1000", R.drawable.icon04));
        adapter.additem(new SingerItem("걸스데이","010-5000-1000", R.drawable.icon05));


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(MainActivity.this, " selected : "+ item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        Button button = findViewById(R.id.button);


    }//onCreate

    public void clickBtn(View view) {
        String name =  etName.getText().toString();
        String mobile =  etMobile.getText().toString();

        adapter.additem(new SingerItem(name, mobile, R.drawable.icon06));
        adapter.notifyDataSetChanged(); // 리스트뷰 갱신 메소
    }

    class SingerAdapter extends BaseAdapter{
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        // Adapter 객체가 만들어낼 View 객체의 개수를 리턴: 필수 구현
        @Override
        public int getCount() {
            return items.size(); //
        }


        // 아이템 데이터 추가를 위한 메소드. 개발자가 원하는대로 작성 가능.
        public void additem(SingerItem item){
            items.add(item);
        }

        // 지정한 위치(position)에 있는 데이터 리턴
        @Override
        public Object getItem(int position) {
            return items.get(position);
        }


        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            SingerItemView view = null;
            // 메모리 로딩을 줄이기 위해서 뷰 재사용 가능하도록
            if(convertView == null) {
                view = new SingerItemView(getApplicationContext());
            }else{
                view = (SingerItemView) convertView;
            }


            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImageView(item.getResId());


            return view;
        }
    }
}
