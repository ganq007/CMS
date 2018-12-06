package com.tms.geq.myapplication.utils;

public class IPUtils {

    public static boolean ipCheck(String text) {
        if (text != null && !text.isEmpty()) {
        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$" ;
        // 判断ip地址是否与正则表达式匹配
        if (text.matches(regex)) { // 返回判断信息
            return true;
        } else {
            return false;
           }
    }
    return false;
    }

}
