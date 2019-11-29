package com.bomnie.hellokotlin

//무조건 main함수는 존재해야함.
fun main(){
    println("Hello Kotlin OOP")
    println()

    //1. 클래스의 선언 및 객체 생성
    //객체 생성 [코틀린은 new 키워드가 존재하지 않음]
    var obj= MyClass()
    obj.show()

    //1-1. 클래스를 별도의 파일로 만들어보기
    var obj2= MyKotlinClass()
    obj2.show()


    //2. 생성자[ 많이 당혹스러움 ]
    //코틀린의 생성자는 2가지 종류가 있음 [ 주생성자, 보조생성자 ]
    //2.1 주 생성자 [ primary constructor ]
    var s= Simple()

    //2.2 주 생성자에 파라미터 전달해 보기
    // 주생성자는 생성자오버로딩이 없음!!!!
    var s2= Simple2(100, 200)
    s2.show()

    //2.3 보조 생성자 : 생성자 오버로딩을 목적으로 만든 것으로 보여짐
    var s3= Simple3()
    var s4= Simple3(1000) //생성자 오버로딩

    //2.4 주생성자와 보조생성자를 같이 사용하기
    // 주생성자를 오버로딩하고 싶을 때 사용함!!!
    var s5= Simple4()//주 생성자 호출
    var s6= Simple4(1000) //보조 생성자 호출

    //# 코틀린은 자바와 다르게 getter, setter()사용을
    //권장하지 않음.

}

//2.4 주생성자와 보조생성자 함께 사용하기 연습
class Simple4 constructor(){
    init {
        println("Simple4 primary constructor")
    }

    //보조생성자(주생성자의 오버로딩용)
    //주의!! 주생성자를 오버로딩하는 보조생성자는 반드시!!
    // 주생성자를 명시적으로 호출해야만 함!!! [ this() 키워드 사용]
    constructor(num:Int) : this(){
        println("Simple4 secondary constructor!!!!")
        println()
    }
}


//2.3 보조 생성자를 사용하는 클래스연습
class Simple3{

    //초기화블럭은 기본적으로 동작함
    init {
        println("이 영역은 객체 생성시에 초기화를 위해 항상 실행됨!!")
    }

    //보조생성자
    constructor(){
        println("Simple3 Secondary 생성자!!!")
        println()
    }

    //보조 생성자는 Overloading 이 됨 [ 보조생성자는 var키워드를 이용하여 곧바로 property를 만들 수 없음]
    constructor(num: Int){
        println("Simple3 Secondary 생성자 : $num ")
        println()
    }
}


//2.2 주 생성자 파라미터 전달받기 연습
// 주생성자의 파라미터 ()안에 var키워드를 명시하고 변수를 만들면
// 그 변수는 이 클래스의 멤버변수(property)가 자동으로 됨!!!!!
class Simple2 constructor(var num:Int, num2:Int){

    init {
        println("Simple2 primary constructor : $num ")
        println("Simple2 primary constructor : $num2 ")
        println()
    }

    fun show(){
        println("num : $num ")
        //println("num : $num2 ") //에러: num2는 주생성자의 지역변수임!!
        println()
    }
}


//2.1 주 생성자 클래스연습 : 클래스명 옆에 constructor()키워드 추가
class Simple constructor(){
    //주 생성자는 코드를 작성하는 {}영역이 없음!!
    //그래서 초기화를 위한 코드 {}블럭이 별도로 존재함
    init {
        //주 생성자가 호출될 때 실행되는 영역
        println("Simple primary constructor!!")
        println()
    }
}



//1. 클래스 선언 [C#언어와 비슷함]
class MyClass{
    //멤버변수 [ 코틀린에서는 멤버변수 property:속성 이라고 부름]
    var a:Int=10

    //멤버메소드
    fun show(){
        println("show : $a ")
        println()
    }
}