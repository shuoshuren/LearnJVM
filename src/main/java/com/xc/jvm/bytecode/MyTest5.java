package com.xc.jvm.bytecode;


/**
 *
 * 方法的静态分派:
 * Grandpa g1 = new Father();
 * 以上代码,g1 的静态类型是Grandpa,而g1的实际类型(真正指向 类型)是father
 * 结论:变量的静态类型是不会发生变化的,而变量的实际类型是可以发生变化(多态的一种体现),实际类型是在运行期间可确定
 *
 *
 */
public class MyTest5 {

    //方法重载,是一种静态的行为,编译期就可以完全确定

    public void test(Grandpa grandpa){
        System.out.println("grandpa");
    }

    public void test(Father father){
        System.out.println("father");
    }

    public void test(Son son){
        System.out.println("son");
    }


    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        MyTest5 myTest5 = new MyTest5();
        myTest5.test(g1);
        myTest5.test(g2);
    }

}


class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}