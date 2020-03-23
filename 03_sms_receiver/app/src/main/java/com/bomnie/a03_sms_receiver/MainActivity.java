package com.bomnie.a03_sms_receiver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionCheck =  ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECEIVE_SMS);
        // 이 권한이 있는지를 한 번 체크해 보겠다라는 의미

        if (permissionCheck == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "SMS 수신 권한 주어져 있음", Toast.LENGTH_LONG).show();
        }else if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            Toast.makeText(this, "SMS 수신 권한 없음 ", Toast.LENGTH_LONG).show();
//
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS)){
//                // 권한에 대한 설명이 필요한가
//                Toast.makeText(this, "SMS 권한 설명 필요함", Toast.LENGTH_LONG).show();
//            }else{
//                // 바로 권한 부여 - 시스템에 요청
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECEIVE_SMS}, 101);
//                // 퍼미션을 여러 개 부여 가능
//
//            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0){
                    if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                        // 사용자가 수락한 경우
                        Toast.makeText(this, "SMS 수신 권한을 사용자가 승인함", Toast.LENGTH_SHORT).show();
                    }else if(grantResults[0]==PackageManager.PERMISSION_DENIED){
                        Toast.makeText(this, "SMS 수신 권한을 사용자가 거부함", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "SMS 수신 권한을 부여받지 못함", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
