package com.util;

/**
 * @ClassName HttpClientUtil
 * @Description HttpClient工具类
 * @Author acer
 * @Date 2019/8/6 16:52
 * @Version 1.0
 **/
public class HttpClientUtil {

    public static void main(String[] args) {
//        doGet();
//        doGetParams();
//        doPost();
        Integer i = new Integer(2);
        a(i);
        System.out.println(i);
    }

    public static void a(int i){
        i = 5;
    }
    // 无参GET方法
    public static void doGet() {

    }

    // 有参GET方法
    public static void doGetParams() {

    }

    // POST方法
    public static void doPost() {

    }
}
