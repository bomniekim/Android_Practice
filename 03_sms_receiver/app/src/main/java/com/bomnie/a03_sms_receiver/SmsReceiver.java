package com.bomnie.a03_sms_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {

    private static final String TAG = "SmsReceiver";

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    // Date 객체의 값을 문자열로 변경해주기 위해서

    @Override
    public void onReceive(Context context, Intent intent) {
        // SMS가 도착했을 때 호출되는 콜백함수
        // 텔레포니 모듈이 인텐트 안에 sms 데이터를 넣어두었음
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        Log.d("TAG", "onReceive 호출됨");

        Bundle bundle= intent.getExtras(); // 번들 객체로 들어있는 데이터
        SmsMessage[] messages = parseSmsMessage(bundle);

        if (messages.length > 0){
            String sender = messages[0].getOriginatingAddress(); // 발신번호
            Log.d(TAG, "발신번호: "+sender);

            String content = messages[0].getMessageBody();
            Log.d(TAG, "내용: "+content);

            Date receivedDate = new Date(messages[0].getTimestampMillis()); // 발신 시각을 데이터 객체로 변환
            Log.d(TAG, "받은시각: "+receivedDate);

            sendToActivity(context, sender, content, receivedDate) ;

        }
    }

    private void sendToActivity(Context context, String sender, String content, Date receivedDate){
        Intent intent = new Intent(context, SmsActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_SINGLE_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("sender", sender);
        intent.putExtra("content", content);
        intent.putExtra("receivedDate", format.format(receivedDate) );

        context.startActivity(intent);


    }

    private SmsMessage[] parseSmsMessage(Bundle bundle){
        Object[] objs =(Object[]) bundle.get("pdus"); // sms 데이터와 관련된 내용이 들어가 있음
        // pdus : sms 데이터를 처리하는 국제표준 프로토콜이 smpp라고 하는데 그 안에 데이터가 이런 이름으로 되어있음
        SmsMessage[] messages = new SmsMessage[objs.length];

        for(int i = 0; i< objs.length; i++){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ){
                String format = bundle.getString("format");
                SmsMessage.createFromPdu((byte[]) objs[i], format);
            }else {
                messages[i]= SmsMessage.createFromPdu((byte[]) objs[i]);
            }
            // byte 배열로 되어 있는 SmsMessage 데이터를 반복문을 통해 뽑아오는 것
        }

        return messages;
        // 번들 객체 안에 인텐트 안에 extra data 로 들어가 있던 데이터를 이용해서
        // SmsMessage 객체로 변환해서 return
    }
}
