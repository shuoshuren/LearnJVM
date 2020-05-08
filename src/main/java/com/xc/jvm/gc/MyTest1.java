package com.xc.jvm.gc;

/**
 *
 * -verbose:gc
 * -Xms20M:堆容量初始大小
 * -Xmx20M:堆容量最大容量
 * -Xmn10M:堆中新生代容量10M
 * -XX:+PrintGCDetails:打印GC详细信息
 * -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=111111:当新生代内存超过某个阈值,新建对象直接值老年代分配内存
 *
 */
public class MyTest1 {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAllocl1 = new byte[3 * size];
        byte[] myAllocl2 = new byte[2 * size];
        byte[] myAllocl3 = new byte[3 * size];

        System.out.println("hello world");
    }
}
