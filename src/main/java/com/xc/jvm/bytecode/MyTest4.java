package com.xc.jvm.bytecode;


/**
 * 栈帧(stack Frame)
 *
 * 栈帧是用于帮助jvm执行方法调用与方法执行的数据结构
 *
 * 栈帧本身是一种数据结构,封装方法的局部变量表,动态连接信息,方法返回地址以及操作数栈等信息
 *
 * 符号引用,直接引用
 *
 * 有些符号引用是在类加载阶段或第一次使用时就会转换为直接引用,这种转换叫做静态解析;
 * 另外一些符号引用则是在每次运行期转换为直接引用,这种转换叫做动态链接,这体现为java的多态性
 *
 * 方法调用的指令:
 * 1.invokeinteface: 调用接口中的方法,实际是在运行期决定的,决定到底调用实现该接口的哪个对象的特定方法.
 * 2.invokestatic:调用静态方法
 * 3.invokespecial:调用自己的私有方法,构造方法以及父类的方法
 * 4.invokevirtual:调用虚方法,运行期动态查找的过程
 * 5.invokedynamic:动态调用方法.
 *
 * 静态解析的四种情形:
 * 1.静态方法
 * 2.父类方法
 * 3.构造方法
 * 4.私有方法
 *
 * 以上4类方法被称为非虚方法,在类加载阶段就可以将符号引用转换为直接引用的
 */
public class MyTest4 {

    public static void test(){
        System.out.println("test invoked");
    }

    public static void main(String[] args) {
        test();
    }
}
