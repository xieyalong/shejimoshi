package com.xyl.test;

import com.xyl.KT.KS;
import com.xyl.KT.KUser;
import com.xyl.KT.SP;


public class Test {
    public static void main(String[] args) {
        String str="a";
        String b=str;
        System.out.println(b.equals(str));
        KS.INSTANCE.run();
    }
}
