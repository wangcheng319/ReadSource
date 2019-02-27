package com.dajiabao.readsource

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        Test("hehehe")
    }

    @Test
    fun test():String{
        var number =  10


        when(number){
             1->"1"
             is Int->"int"
             in 1..10 ->"1..10"
             else ->"null"
        }


        return "hello"
    }

    fun Test(num:String){
        System.out.print(num)
    }

    @Test
    fun test1():String{
        var i = 10
        when(i){
            in 1..10-> return "10"
        }

        return "1"
    }

    @Test
    fun testLet(){
        val list: MutableList<String> = mutableListOf("A","B","C")
        val change: Any
        change = list.let {
            it.add("D")
            it.add("E")
            it.size
        }
//        println("list = $list")
        assertEquals(5,"change = $change")
    }
}
