package com.xc.jvm.bytecode;


/**
 * 1.使用javap -verbose 命令分析一个字节码文件时,将会分析该字节码文件的魔数,版本号,常量池,类信息,类的构造方法
 * 类中的方法信息,类变量与成员变量等信息
 * 2.魔数:所有的.class文件的前4个字节都是魔数,固定值为:OxCAFEBABE
 *
 * 3.版本号:魔术之后4个字节码为版本号,前两个表示minor version,后两个表示major version(主版本号)
 *
 * 4.常量池(constant pool):紧接着主版本好之后的就是常量池入库,一个java类中定义的很多信息都是由常量此来维护和描述的
 * 可以将常量池看做是class文件的资源仓库,比如java中定义的方法与变量信息,都是存储在常量池中,常量池中主要存储连累
 * 常量:字面量与符号引用,字面量如文本字符串,java中声明为final的常量值等,而符号引用如类和接口的全局限定名,字段的
 * 名称和描述符,方法的名称和描述符
 * 5.常量池的总体结构:java类所对应的常量池主要由常量池数量与常量池数组则两个部分共同构成.常量池数量紧跟在主版本
 * 后面,占据2个字节;常量池数组紧跟在常量池数量之后.常量池数组与一般的数组不同的是,常量池数组不同元素的类型,结构都是不同.
 * 长度当然也就不同;但是每一个元素的第一个数据都是一个u1类型,该字节是个标志位,占据一个字节,jvm在解析常量池时.
 * 会根据这个u1类型来获取元素的具体类型.值得注意:常量池中元素的个数 = 常量池数 - 1 (其中0暂时不使用),目的
 * 是满足某些常量池索引值的数据在特定情况下需要表达[不引用任何一个常量池]的含义;根本原因在于,索引0也是一个常量(保留常量),
 * 只不过它不位于常量表中,这个常量就对应null值,所以,常量池的索引从1而非0开始
 *
 * 6.在JVM规范中,每个变量/字段都有描述信息,描述信息主要的作用是描述字段的数据类型,方法的参数列表(包括数据,类型,与顺序)与返回值.根据
 * 描述符规则,基本数据类型和代码无返回值的void类型都用一个大写字符来表示,对象类型则使用字符L加对象的全限定名称来表示,为压缩字节码
 * 体积,对基本数据类型,jvm都只用一个大写字母来表示: B - byte, C - char, D - double, F - float,I - int,
 * J - long, S - short, Z - boolean, V - void, L - 对象类型
 *
 * 7.对于数组类型来说,每一个维度使用一个前置的[来表示,如int[] 被标记为[I,String[][]被标记为[[Ljava/lang/String;
 * 8.用描述符来描述方法是,按照先参数列表,后返回值的顺序来描述.参数列表按照参数的严格顺序放在一组()之内,如方法:String getRealNameByIdAndNickName(
 * int id,String name)的描述符为:(I,Ljava/lang/String;)Ljava/lang/String;
 *
 * 9. 访问标示符(Access Flag):2个字节,包括该class文件是类还是接口,是否被定义成public,是否是abstract,
 * 如果是类,是否被声明为final
 *
 * 10.当前类的名字:2个字节
 *
 * 11.父类的名字:2个字节
 *
 * 12.接口:接口数量(u2)+接口表(u2)
 *
 * 13.字段表:字段表个数(u2)+字段表 用于描述类和接口中声明的变量.这里的字段包含了类级别变量以及实例变量,
 * 但是不包括方法内部声明的局部变量
 * fields_count:u2
 * field_info {
 *     u2 access_flags;
 *     u2 name_index;
 *     u2 descriptor_index;
 *     u2 attributes_count;
 *     attribute_info attributes[attributes_count];
 * }
 *
 * 14.方法表:方法个数(u2)+方法表
 * method_info {
 *     u2 access_flags;
 *     u2 name_index;
 *     u2 descriptor_index;
 *     u2 attributes_count;
 *     attribute_info attributes[attributes_count];
 * }
 * 方法中的每一个属性都是一个attribute_info结构
 * attribute_info {
 *     u2 attribute_name_index;
 *     u4 attribute_length;
 *     u1 info[attribute_length];
 * }
 * JVM预定义了部分attribute,但是编译器自己也可以实现自己的attribute写入class文件里,供运行时使用
 * 不同的attribute通过attribute_name_index来区分
 *
 * 15.code结构 保存该方法的结构
 * Code_attribute {
 *     u2 attribute_name_index;
 *     u4 attribute_length; //表示attribute所包含的字节数,不包括attribute_name_index和attribute_lenght字段
 *     u2 max_stack; //表示方法运行的任何时刻所能达到的操作数栈的最大深度
 *     u2 max_locals;//表示方法执行期间创建的局部变量的个数,包括用来表示传入的参数的局部变量
 *     u4 code_length;//表示方法所包含的字节码的字节数以及具体的指令码
 *     u1 code[code_length];//jvm执行的字节码
 *     u2 exception_table_length;
 *     {
 *         u2 start_pc; //在code数组中的[start_pc,end_pc)的指令抛出的异常会由这个表项来处理
 *         u2 end_pc;
 *         u2 handler_pc; //处理异常代码的开始处
 *         u2 catch_type; //表示被处理的异常类型,指向常量池里的一个异常类.当catch_type为0,表示处理所有的异常
 *     } exception_table[exception_table_length]; //处理异常的信息
 *     u2 attributes_count;
 *     attribute_info attributes[attributes_count];
 * }
 *
 * LineNumberTable:这个属性表示code数组中的字节码与java代码行数之间的关系,可以用来在调试的时候定位代码执行的行数
 */
public class MyTest1 {

    private int a = 1;


    public int getA() {
        return this.a;
    }

    public void setA(int a) {
        this.a = a;
    }

}
