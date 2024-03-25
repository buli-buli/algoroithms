package test;

import java.lang.reflect.Field;

/**
 * @ClassNAME StringTest
 * @Description 字符串对象测试类
 * @Author yu
 * @Date 2023/7/7 15:32
 * @Version 1.0
 */
public class StringTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        changeValue();
//        testStringEqual();
//        testIntegerEqual();
        replaceSubString();
    }

    private static void testIntegerEqual() {
        Integer i1 = 100;
        Integer i2 = 100;
        //i1 == i2 ? true or false
        System.out.println(i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;
        //i3 == i4 ? true or false
        System.out.println(i3 == i4);
    }

    //在不改变s引用指向的情况下让输出变为abcd
    private static void changeValue() throws NoSuchFieldException, IllegalAccessException {
        String s = new String("abc");

        Field value = s.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(s, "abcd".toCharArray());
        value.setAccessible(false);

        System.out.println(s);
    }

    private static void testStringEqual(){
        String s1 = new String("abc");//生成了2个对象 String对象（放在堆里面）和字符串常量对象（放在字符串常量池）
        String s2 = "abc";//先从字符串常量找，如果有直接赋值
        //s1 == s2 ? true or false
        System.out.println(s1 == s2);//false

        String s3 = s1.intern();
        //s2 == s3 ? true or false
        System.out.println(s2 == s3);//true
    }

    private static void replaceSubString(){
        StringBuilder builder = new StringBuilder("abc");
        String s = "eee";
        builder.replace(0, 2, s);
        System.out.println(builder.toString());
    }
}
