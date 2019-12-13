package com.bomnie.myspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<String> adapter;
    TextView tv;

    String[] items= {"창모", "효은", "해쉬", "릴러"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        tv=findViewById(R.id.tv);

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items

        );

        //스피너의 아이템을 클릭해서 dropdown 된 아이템들의 View 모양 설정
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //스피너의 아이템이 선택되는 것을 듣는 리스너
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv.setText(items[position ]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tv.setText("선택 : ");

            }
        });
    }
}
