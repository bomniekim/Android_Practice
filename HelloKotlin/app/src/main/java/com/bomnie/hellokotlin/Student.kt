package com.bomnie.hellokotlin

open class Student constructor(name:String, age:Int, var major:String) : Person(name, age) {
    init {
        println("create Student instance")
    }

    //override 키워드를 추가하면 open키워드가 적용 된 것임.
    override fun show(){
        println("name: $name  age: $age  major: $major")
    }
}