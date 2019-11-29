package com.bomnie.hellokotlin

//보조 생성자를 이용하여 상속할 때는 부모생성자의
//클래스명 뒤에 ()를 쓰지 않고...자식 클래스의 보조생성자에서
//super()로 호출해야 함.
class Teacher : Person {

    //Teacher클래스의 고유한 property(멤버변수)
    var subject:String?= null

    //보조 생성자
    constructor(name:String, age:Int, subject:String): super(name, age){
        //내 멤버변수에 값 대입하기
        this.subject= subject
        println("create Teacher instance")
    }

    override fun show() {
        println("name: $name  age: $age  subject: $subject")
    }

}
