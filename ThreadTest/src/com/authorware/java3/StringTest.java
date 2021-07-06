package com.authorware.java3;
import org.junit.Test;

/**
 * @Author Simon Zhang
 * @Date 2021/6/29 9:23 下午
 * @Version 1.0
 */
public class StringTest {

    @Test
    public void test2() {
        //通过字面量定义的方式，此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new + 构造器的方式：此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值。
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s3 == s4);

        Person tom1 = new Person("Tom", 20);
        Person tom2 = new Person("Tom", 20);
        System.out.println(tom1.name.equals(tom2.name));
        System.out.println(tom1.name == tom2.name);
    }
    /**
     * String:字符串，使用一对""引起来表示。
     * String声明为final的，不可被继承
     * String实现了Serializable接口：表示字符串是可以支持序列化的
     *       实现了Comparable接口：表示String可以比较大小
     * String：代表不可变的字符序列。简称：不可变性。
     *  体现：1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value赋值。
     *  2.当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value。
     *  3.当调用String的replace方法修改字符或者字符串时，也需要重新指定内存区域赋值。
     * 通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
     * 字符串常量池中是不会存储相同内容的字符串的。
     *
     */
    @Test
    public void test1() {
        String s1 = "teststring";
        String s2 = "teststring";
        System.out.println(s1 == s2);
        System.out.println(s1);
    }
}
