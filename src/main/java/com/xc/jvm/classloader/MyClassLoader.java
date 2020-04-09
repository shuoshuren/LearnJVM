package com.xc.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 自定义ClassLoader
 */
public class MyClassLoader extends ClassLoader {

    private String mClassLoaderName;

    private String path;

    private static final String file_Extension = ".class";

    public static final String DESKTOP_PATH = "/home/xc/桌面/";

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public MyClassLoader(String classLoaderName){
        super();//将系统类加载器作为父加载器
        this.mClassLoaderName = classLoaderName;
    }

    public MyClassLoader(ClassLoader parent,String classLoaderName) {
        super(parent);//将parent作为父加载器
        this.mClassLoaderName = classLoaderName;

    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "["+this.mClassLoaderName+"]";
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass:"+this.mClassLoaderName);
        byte[] data = this.loadClassData(className);

        return this.defineClass(className,data,0,data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream out = null;

        try{
            name = name.replace(".","/");
            File file = new File(this.path + name + file_Extension);
            is = new FileInputStream(file);
            out = new ByteArrayOutputStream();

            int ch = 0;
            while (-1 != (ch = is.read())) {
                out.write(ch);
            }
            data = out.toByteArray();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                if(is != null) {
                    is.close();
                }
                if(out != null) {
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return data;
    }
}
