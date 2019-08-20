package study.thread;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/3/26 09:07
 */
public  class Test3 {




    public static void main(String[] args) {
       /* Integer integer1 = 178;
        Integer integer2 = 178;
        int b1 = 1;
        Byte b2 = 1;
        String s2 = "1shuaizi";
        String s1 = new String("1")+new String("shuaizi");
        String s3=s1.intern();


        String a5 = new String("A") + new String("A");//只在堆上创建对象
        a5.intern();//在常量池上创建引用
        String a6 = "AA";//此时不会再在常量池上创建常量AA，而是将a5的引用返回给a6
        System.out.println(a5 == a6);*/



        String s1 = new String("111");
        String s2 = new String("111");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));




    }
}
