package com.authorware.java4;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Simon Zhang
 * @Date 2021/7/6 9:24 下午
 * @Version 1.0
 */
public class DateTimeTest {
    @Test
    public void testSimpleDateFormat() throws ParseException {
        // 实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        //格式化：日期--->字符串
        Date date = new Date();
        System.out.println(date);
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串--->日期
        String str = "21-7-6 下午9:59";
        Date parse = simpleDateFormat.parse(str);

        System.out.println(parse);

        //按照指定的方式格式化和解析，调用带参的构造器
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat1.format(date);
        System.out.println(format1);

        //解析：要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器的参数体现），否则，抛异常。
        Date parse1 = simpleDateFormat1.parse("2021-07-07 11:21:37");
        System.out.println(parse1);
    }

    /*
    字符串"2021-07-12"转换为java.sql.Date
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2021-07-12";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(birth);
        System.out.println(date);

        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
    }
    /*
    "三天打鱼两天晒网" 1990-01-01 起
    举例 2020-09-08
    总天数 % 5 === 1，2，3 打鱼
    总天数 % 5 === 4，0 晒网

    总天数的计算？
    方式一：找到两个时间的毫秒数 做减法 / (1000 * 60 * 60 * 24) + 1
    方式二：1990-01-01 --> 2019-12-31 + 2020-01-01 --> 2020-090-08
     */
}
