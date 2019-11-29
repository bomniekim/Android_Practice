package com.bomnie.hellokotlin

fun main() {
    // 안드로이드 개발 시 많이 사용되는 3가지

    // 1. 이너클래스
    // 이너클래스 객체 생성

    var obj = AAA()
    var obj2 = obj.instantateBBB()
    obj2.show()

    // 2. 인터페이스
//    var c= Clickable() // error : 인터페이스는 곧바로 객체 생성이 불가
     var c= Test()
    c.onClick()

    // 3. 익명클래스 : 인터페이스를 익명의 클래스로 구현하면서 객체 생성
    var a= object : Clickable {
        override  fun onClick(){
            println("Anonymous class onClick!")
            println()
        }

    }
    a.onClick()

}

// 2. 인터페이스
interface Clickable{
    //추상메소드
    fun onClick()
}

// 2.1 인터페이스를 구현한 클래스
class Test : Clickable{
    override fun onClick(){ // 오버라이드를 명시적으로 적시
        println("Click!")
        println()
    }
}


//1. 클래스안에 클래스를 선언하는 inner class 연습
    class AAA {
    var a: Int = 10


    fun show() {
        println("AAA클래스의 show")
        println()
    }

    // 아우터클래스 안에 이너클래스 객체를 생성하여 리턴해주는 메소드를 만들고 사용
    fun instantateBBB(): BBB {
        return BBB() // 아우터클래스는 이너클래스 객체를 생성할 수 있음
    }

    // 이너클래스 : 자바와 다르게 inner class 임을 *명시적으로 표기해야만* 사용 가능
    inner class BBB { // AAA 클래스 안에 숨어 있는 클래스

        fun show() {
            // 이너클래스는 아우터클래스의 멤버를 내 것인양 사용 가능( 결정적인 장점)
            println("아우터클래스의 프로퍼티 a  :  $a")

            // 이너클래스에서 아우터클래스의 this를 사용하는 문법이 자바와 다름
            // 아우터의 show() 메소드 호출해보기
            this@AAA.show()
        }
    }
}