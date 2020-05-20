package com.xc.jvm.g1;


/**
 *
 * G1 vm 参数
 * -verbose:gc
 * -Xms10m
 * -Xmx10m
 * -XX:+UseG1GC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:MaxGCPauseMillis=200m
 *
 *
 *
 */
public class MyTest1 {

    public static void main(String[] args) {
        int size = 1024* 1024;
        byte[] mAlloc1 = new byte[size];
        byte[] mAlloc2 = new byte[size];
        byte[] mAlloc3 = new byte[size];
        byte[] mAlloc4 = new byte[size];
        System.out.println("hello world");
    }
}
