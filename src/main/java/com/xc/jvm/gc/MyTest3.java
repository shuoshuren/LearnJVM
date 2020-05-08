package com.xc.jvm.gc;

/**
 * -verbose:gc
 * -Xmx200M
 * -Xmn50M
 * -XX:TargetSurvivorRatio=60
 * -XX:+PrintTenuringDistribution
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseParNewGC
 * -XX:MaxTenuringThreshold=3
 *
 *
 *
 *
 */
public class MyTest3 {

    public static void main(String[] args) throws InterruptedException {
        byte[] bytes1 = new byte[512*1024];
        byte[] bytes2 = new byte[512*1024];

        myGc();
        Thread.sleep(1000);
        System.out.println("111111");

        myGc();
        Thread.sleep(1000);
        System.out.println("22222");

        myGc();
        Thread.sleep(1000);
        System.out.println("333333");

        myGc();
        Thread.sleep(1000);
        System.out.println("44444");

        byte[] bytes4 = new byte[1024*1024];
        byte[] bytes5 = new byte[1024*1024];
        byte[] bytes6 = new byte[1024*1024];

        myGc();
        Thread.sleep(1000);
        System.out.println("555555");

        myGc();
        Thread.sleep(1000);
        System.out.println("666666");
        System.out.println("hello world");

    }

    private static void myGc(){
        for (int i = 0; i < 40; i++) {
            byte[] byteArray = new byte[1024*1024];
        }
    }
}
