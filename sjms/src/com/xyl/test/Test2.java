package com.xyl.test;

import java.util.Calendar;

public class Test2 {
    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        //获取年月日
        int year=calendar.get(Calendar.YEAR);//年
        for (int i = 0; i <3 ; i++) {
            System.out.println(year-i);
        }
    }
}
