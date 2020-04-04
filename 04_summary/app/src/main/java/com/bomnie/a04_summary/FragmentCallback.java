package com.bomnie.a04_summary;


/*
프래그먼트 자체는 어떤 액티비티로든 올라갈 수 있는데
그것이 특정 액티비티가 아니므로 어느 액티비티로 한정하여 정의하기 보다는
인터페이스를 구현해서 그 인터페이스를 참조할 수 있도록
- 어떤 액티비티 위에서 올라가더라도 그 프래그먼트 사용 가능
*/

public interface FragmentCallback {

    public void onCommand(String command, String data);
}
