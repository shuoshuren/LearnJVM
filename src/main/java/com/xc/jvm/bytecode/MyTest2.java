package com.xc.jvm.bytecode;


/**
 *
 * synchronized在字节码中表示:
 * monitorenter
 * monitorexit
 *
 *
 */
public class MyTest2 {


    private int x = 5;

    private Object obj = new Object();

    private void test() {
        System.out.println("hello");
    }

    public void setX(int x) {
        synchronized (this.obj) {
            this.x = x;

        }
    }
}
