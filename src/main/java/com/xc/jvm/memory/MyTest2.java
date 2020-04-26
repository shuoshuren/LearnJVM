package com.xc.jvm.memory;


/**
 * 虚拟机栈溢出
 * -Xss250k:设置栈大小
 */
public class MyTest2 {

    private int length;

    public int getLength() {
        return length;
    }

    public void test() {
        this.length++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }

    public static void main(String[] args) {
        MyTest2 test = new MyTest2();
        try {

            test.test();
        } catch (Error error) {
            System.out.println("length:"+test.getLength());
            error.printStackTrace();
        }

    }
}
