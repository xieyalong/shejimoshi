package com.xyl.KT


class OpenClose{
    fun open(ioc:IOpenClose){
        ioc.open()
    }
}

interface  IOpenClose{
    fun open()
}
class  ZhangSan:IOpenClose{
    override fun open() {
        println("这是张三打开的")
    }
}
class  LS:IOpenClose{
    override fun open() {
        println("这是李四打开的")
    }
}
fun main() {
    var zs=ZhangSan()
    var oc=OpenClose()
    oc.open(zs)
    var ls=LS()
    oc.open(ls)
}