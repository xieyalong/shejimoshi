package com.xyl.KT

import cn.hutool.cache.CacheUtil
import cn.hutool.http.HttpUtil
import cn.hutool.json.JSONObject
import cn.hutool.json.JSONUtil


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

}


fun main() {
    var str=HttpUtil.get("http://www.phonegap100.com/appapi.php?a=getPortalList&catid=20&apge=1")
    var jo=JSONObject(str)
    println(jo)
    var json=jo.getJSONObject("result")
    print(json.getStr("title"))
    println("")

}

