package com.bomnie.a04_drawer;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentCallBack {

    private AppBarConfiguration mAppBarConfiguration;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // 툴바 설정을 위한 기본 코드

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        navigationView.setNavigationItemSelectedListener(this);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment1).commit();

    }

    @Override
    public void onFragmentItemSelected(int position, Bundle bundle) {
        Fragment curFragment = null;
        if (position == 0){
            curFragment = fragment1;
            toolbar.setTitle("1번화면");
        }else if(position == 1){
            curFragment = fragment2;
            toolbar.setTitle("2번화면");
        }else if(position == 2){
            curFragment = fragment3;
            toolbar.setTitle("3번화면");
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_0) {
            Toast.makeText(this, "1번 선택됨", Toast.LENGTH_SHORT).show();
            onFragmentItemSelected(0, null);
        } else if (id == R.id.nav_1) {
            Toast.makeText(this, "2번 선택됨", Toast.LENGTH_SHORT).show();
            onFragmentItemSelected(1, null);
        } else if (id == R.id.nav_2) {
            Toast.makeText(this, "3번 선택됨", Toast.LENGTH_SHORT).show();
            onFragmentItemSelected(2, null);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
