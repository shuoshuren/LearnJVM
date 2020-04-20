package com.xc.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;


/**
 * 对于java类每一个实例方法(非static方法),其在编译后所生成的字节码当中,方法的参数数量总是会比源代码中方法
 * 参数的数量多一个(this),位于方法的第一个参数位置处;这样,就可以在java实例方法中使用this来去访问当前对象的
 * 属性以及其他方法
 *
 * 这个操作是在编译期间完成的,即由javac编译器在编译的时候将对this的访问转换为一个普通实例方法参数的访问;
 * 接下来在运行期间,由jvm在调用实例方法时,自动向实例方法传入this参数.所以,在实例方法的局部变量表中,至少会有一个指向当前对象的局部变量
 *
 *
 */
public class MyTest3 {

    public void test() {
        try {
            InputStream is = new FileInputStream("test.txt");
            ServerSocket socket = new ServerSocket(9999);
            socket.accept();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
