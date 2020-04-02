package com.bomnie.a04_drawer;

import android.os.Bundle;

public interface FragmentCallBack {

    // 인터페이스를 구현하여 MainActivity

    public void onFragmentItemSelected(int position, Bundle bundle);
    // bundle: 필요한 경우 추가적인 데이터를 번들 안에 넣어서 전달할 수 있도록
}
