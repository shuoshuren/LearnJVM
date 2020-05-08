package com.xc.jvm.gc;


/**
 *
 * -XX:PretenureSizeThreshold=4194304:设置对象超过某个阈值,新建对象直接值老年代分配内存
 * -XX:UseSerialGC
 * -XX:MaxTenuringThreshold=5
 * MaxTenuringThreshold作用:在可以自动自动调节对象晋升(Promote)到老年代阀值,设置该阀值的最大值,该参数默认值为15
 * CMS中默认值为6,G1中默认为15(在jvm中,该数值是由4个bit表示,最大值为1111,即15)
 *
 * 经历多次GC后,存活对象会在From Survivor和To Survivor之间来回存放,在这里面的一个前提是这两个空间有足够大的空间来存放数据.
 * 在GC算法中,会计算每个对象的年龄大小,如果达到某个年龄后发现总大小已经大于Survivor空间的50%,那么就需要调整阀值,不能再等待默认的
 * 15次gc后才完成晋升,因为只会导致Survivor空间不足,所以需要调整阀值,让这些存活对象尽快完成晋升.
 *
 *
 */
public class MyTest2 {

    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] alloc = new byte[5*1024];
    }
}
