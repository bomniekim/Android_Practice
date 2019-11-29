package com.bomnie.hellokotlin

class AlbaStudent constructor(name:String, age:Int, major:String, var task:String) : Student(name, age, major) {
    init {
        println("create AlbaStudent instance")
    }

    override fun show() {
        //super.show()
        println("name: $name  age: $age  major: $major  task: $task")
    }
}