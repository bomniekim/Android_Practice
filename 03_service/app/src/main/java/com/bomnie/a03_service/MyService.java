package com.bomnie.a03_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService"; // 상수 정의



    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate 호출됨");
    }

    // 서비스는 한번 만들어지면 계속 실행되어 있는 특성이 있으므로
    // 인텐트로 전달한 extra data 를 확인할 때는 onStartCommand()로 확인함

    // onStartCommand()가 호출되면 인텐트 객체를 파라미터로 전달받을 수 있으므로
    // 인텐트 안에 들어있는 명령이나 데이터를 확인하여 필요한 기능을 수행할 수 있음
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand 호출됨");

        if (intent == null){
            return Service.START_STICKY;
            // 서비스가 종료되었을 때도 자동으로 다시 실행해달라
        }else {
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);

    }

    private void processCommand(Intent intent){
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Log.d("TAG", "전달받은 데이터:"+command+", "+name);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                Intent.FLAG_ACTIVITY_SINGLE_TOP|
                Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // 서비스는 화면이 없기 때문에 화면을 띄우려고 하면 '태스크'라는 정보가 없어서
        // 문제가 생길 수 있기 때문에 옵션을 줌
        showIntent.putExtra("command", "show");
        showIntent.putExtra("name", name+" from service");
        startActivity(showIntent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy 호출됨");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
