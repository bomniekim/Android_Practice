package com.bomnie.hellokotlin

// 코틀린 언어 기초 문법 [ 코틀린 연습 사이트: https://try.kotlinlang.org ]

// 문법적 주요 특징
// A. 문장의 끝을 나타내는 ; 을 사용하지 않음 (써도 ok, 옵션임)
// B. 변수를 만들 때 자료형을 사용하지 않고 var 이라는 키워드를 사용함. 단, 자료형을 존재 (자동 형변환 안됨)
// C. 코틀린은 "함수형 언어"다. 쉽게 말하자면 함수를 객체처럼 변수에 저장하고 파라미터로 넘겨주는 등의 작업이 가능 (객체지향 프로그래밍 언어 아님)

// 1. 프로그램의 시작함수인 main() 함수가 반드시 있어야 함
// 2. 함수를 정의할 때 리턴타입 위치에 'fun' 키워드 (function 약자) 사용

fun main() {
    // 3. 화면 출력: print(), println() 함수
    println("Hello Kotlin")
    println(10)
    println(10.5)
    println('A')
    println(true)
    println(5 + 3)
    // ; 이 없기에 한 줄에 2개의 명령을 사용하면 error
    //println(10) println(10) // error

    // 4. 자료형과 변수
    // 4.1 기본자료형: Boolean, Char, Byte, Short, Int, Long, Float, Double, String, Any
    // [ 코틀린은 모든 자료형이 참조형 자료형임.. 즉, 모든 변수가 객체임] // 모두 대문자로 시작
    // -Boolean, String, Any, Char 는 Number Type 이 아님!

    //4.2 변수 선언 문법 [ var 키워드 사용 : variable의 약자]
    //var a // ; 이 없어서 변수 만들 때 값을 초기화 하지 않으면 에러!
    var a = 10
    var b = 1.1
    var c = 3.14f
    var d = true
    var e = 'A'
    var f = "Hello"
    // 주의! 변수 선언 시에 자료형 표기가 없지만 값을 대입할 때 자료형이 추정되기에 값이 대입될 때 변수의 자료형이 결정됨
    // 변수이므로  값의 변경 가능

    a = 20
    b = 20.5
    println(a)
    println(b)
    println()

    // 자료형이 다른 값을 넣으면 error!
    //a = 3.14 //error
    // b=50 // error [자동형변환 안됨]

    // 명시적 형변환하는 방법
//    a = (Int)3.14 // 이런 문법 없음
    a = 3.14.toInt() // ->3
    b = 50.toDouble() // ->50.0
    println(a)
    println(b)
    println()

    // 자료형을 명시적으로 표기하면서 변수 선언 가능
    var a2: Int = 100
    var b2: Double = 3.15
    var c2: Boolean // 명시적으로 자료형을 표기하면 변수 선언 시 초기화를 하지 않아도 ok
    println(a2)
    println(b2)
    //println(c2) // error

    // 정수값 표기의 특이한 점 [실생활에서 숫자의 3자리마다 , 로 구분하듯이]
    var a3 = 5_000_000

    //** 화면 출력의 format 만들기
    println("Hello" + "Kotlin") // 문자열 결합

    // Number 타입과 String 의 자동형변환이 안됨
    // println(10+"Hello") // error

    // 위의 작업을 하고 싶다면
    println(10.toString() + "Hello")

    // 특이한 점! String 을 먼저 작성하면 형변환 됨
    println("Hello" + 10)

    // 2개의 변수값을 덧셈하여 출력하기
    var num1 = 10
    var num2 = 30
    //println( "" + num1 + "+"+num2+"="+(num1+num2) ) // Java 에서는 이렇게..
    println("" + num1 + " + " + num2 + " = " + (num1 + num2))
    println(num1.toString() + " + " + num2.toString() + " = " + (num1 + num2))


    // 위 두 방법 모두 실수의 여지가 많음! 그래서..
    println("$num1 + $num2 = ${num1 + num2}")
    println()
    // 이렇게 $ 변수명을 사용하는 것을 [ 문자열 template] 이라고 부름

    //즉
    var name = "Sam"
    var age = 20
    println("이름 : $name \n나이: $age")
    println()

    // Any 타입 [Java 의 Object 클래스와 비슷]
    var v: Any
    v = 10
    println(v)

    v = 3.14
    println(v)

    v = "Hello"
    println(v)
    println()

    // 변수에 값 대입할 때 체크!
    // null 값 대입에 관하여
    var n = null
    println(n)

    // 자료형을 명시하면 기본적으로 null 을 저장할 수 없음
    // var n2: Int= null // error
    // var s: String = null // error

    // null 값을 가질 수 있는 변수라고 표시할 수 있음 : ? 사용
    var n3: Int? = null // 명시적으로 nullable
    var v2: String? = null
    println(n3)
    println(v2)
    println()

    // 4.3 상수 만들기 [val 키워드:  value 약자]
    val m = 10
    //m= 15 // error

    // 자료형이 명시되어 있으면 다음 줄에 대입 가능
    val m2: Int
    m2 = 100
    // m2=200 // error : 상수는 변경불가


    //5. 연산자의 특이한 점
    //숫자 타입들간의 연산은 자동형변환 됨
    println(10 + 3.14)

    //println(10+true) //error
    //println(10+'A')  //error

    //자료형을 체크해주는 연산자 is
    var n4 = 10
    if (n4 is Int) {
        println("n4 변수는 Int 형입니다.")
    }

    var s3: String = "Hello"
    if (s3 is String) println("s3는 String 변수입니다.")
    if (s3 is String?) println("s3는 String 변수입니다.")
    println()

    // !is 도 있음.
    if (s3 !is String) println("String 타입이 아닙니다.")

    //서로 다른 자료형은 is 연산자로 체크할 수 없음
   //  if( n4 is String ) {} //ERROR 메세지: String 과 Int 는 양립할 수 없습니다.

    // *is 연산자는 Any 타입에 대한 식별로 사용됨*
    var obj: Any

    obj = 10.5
    if (obj is Int) println(" ${obj}는 Int 입니다.")
    if (obj is Double) println(" ${obj}는 Double 입니다.")

    // Java 의  instanceof 연산자와 비슷하게 사용 가능함

    class Person {
        //코틀린은 멤버변수를 property[속성] 라고 부름
        var name = "Sam"
        var age: Int = 20
    }

    //Person 클래스의 객체를 생성
    //Person p= new Person(); //java 에서는 new 키워드로 객체 생성.
    var p = Person() //코틀린에서의 객체 생성에는 [new 키워드 없음]
    if (p is Person) {
        println(p.name + "   " + p.age)
    }

    //Any 타입에 적용하는 경우가 많음
    obj = Person()
    if (obj is Person) {
        println("이름: ${p.name} \n나이: ${p.age}")
    }


    //문자열 비교에 == 연산사 사용 가능[equals()와 같은 결과]
    var s4 = "Hello"
    var s5 = "Hello"
    if (s4 == s5) println("aaaa")
    if (s4.equals(s5)) println("bbbb")
}
