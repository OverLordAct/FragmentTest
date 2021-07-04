package com.joydeep.fragmenttest

class A constructor(fName: String = "A") {
    private lateinit var name: String
    private var age: Int = 0
    private var height: Int = 0

    constructor(name: String, age: Int): this() {
        this.name = name
        this.age = age
    }
}

fun main() {
    val a = A()
}