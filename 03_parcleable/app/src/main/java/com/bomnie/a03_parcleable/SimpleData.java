package com.bomnie.a03_parcleable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements  Parcelable {

    int number;
    String msg;


    public SimpleData(int number, String msg) {
        this.number = number;
        this.msg = msg;
    }

    public SimpleData(Parcel src){
        // Parcel에서 SimpleData 안에 들어가 있는 변수를 read로 복원
        number= src.readInt();
        msg= src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        @Override
        public Object createFromParcel(Parcel src) {
            return new SimpleData(src);
        }

        @Override
        public Object[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // SimpleData 를 Parcel로 바꾸어 주는 것
        dest.writeInt(number);
        dest.writeString(msg);

    }
}


// Parcel : 객체 안에 있는 데이터를 다른 데 전달할 때 사용되는 객체