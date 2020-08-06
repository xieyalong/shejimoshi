package com.xyl.KT

import com.alibaba.fastjson.JSON
import jdk.internal.util.xml.impl.Input
import org.apache.commons.io.FileUtils
import org.omg.CORBA.Object
import java.io.File
import java.time.Year
import kotlin.concurrent.thread


open abstract class SP{
    abstract fun  run():Int
}
//class Sp1:SP(){
//    override fun run->0
//}

class KUser {
    var type=0
    var name:String?=null
    get() {
        println("获取name")
        if (type==0){
            field="aaa"
            return field
        }
        return field
    }
    set(value) {
        //不用 this.name=value
        //当u.name="aaa"时候 先get，在set
        field=value
        println("设置name="+name)
    }
}

object  KS{
    fun run(){

    }
}

fun main() {
    println("")
}

