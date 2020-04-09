package com.xc.jvm.classloader;


/**
 *
 * 对于数组实例来说,其类型是由JVM在运行期间动态生成,表示为[Lcom.xxx这种形式.
 * 动态生成的类型,其父类型就是Object
 * 对于数组来说,JavaDoc经常将构成数据的元素称为Component,实际就是将数组降低一个维度后的类型
 *
 * 助记符:
 * anewarray:表示创建一个引用类型(类,接口)的数组,并压入栈顶
 * newarray:表示创建一个指定的原始类型(int,float)的数组,并将其压入栈顶
 *
 */
public class MyTest4 {

    public static void main(String[] args) {
//        MyParent4 myParent4 = new MyParent4();


        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());
        System.out.println("=====");
        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        char[] chars = new char[1];
        System.out.println(chars.getClass());

        boolean[] booleans = new boolean[1];
        System.out.println(booleans.getClass());

        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());

    }
}


class MyParent4{

    static {
        System.out.println("MyParent4 static block");
    }
}