package com.xc.jvm.memory;


/**
 * jps -l :查看java应用的pid
 * jcmd (从jdk7开始引入的命令)
 * 1.jcmd pid VM.flags:查看jvm的启动参数
 * 2.jcmd pid help:列出当前运行的java进程可执行的操作
 * 3.jcmd pid VM.uptime:查看jvm的启动时长
 * 4.jcmd pid PrefCounter.print :查看jvm性能相关的参数
 * 5.jcmd pid GC.class_histogram:查看系统中类的统计信息
 * 6. jcmd pid Thread.print:查看线程的堆栈信息
 * 7. jcmd pid GC.heap_dump <filename>:导出heap dump文件
 * 8 jcmd pid VM.system_properties:查看jvm的属性信息
 * 9. jcmd pid VM.version : 获取jvm进程的版本信息
 *
 * jstack: 可以查看或者导出java应用程序中线程的堆栈信息
 * jmd:java mission control
 * jfr:java flight recorder
 *
 *
 */
public class MyTest5 {

    public static void main(String[] args) {
        for (;;) {
            System.out.println("hello world");
        }
    }
}
