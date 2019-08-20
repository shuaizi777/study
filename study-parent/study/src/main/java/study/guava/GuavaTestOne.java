package study.guava;

import study.io.IOTest;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/6/2 19:06
 */
public class GuavaTestOne extends IOTest implements Cloneable {

    public static void nanShou(String... a) {
        System.out.println(a[1]);
    }

    public void t2() {

    }

    @Override
    public String t1() {
        return "enenene";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }



    public static void main(String[] args) {

        /*//Preconditions.checkArgument(1 > 2, "is right");
        //String a = null;
       //Preconditions.checkNotNull(a, "s%置为空", a);
        Preconditions.checkElementIndex(3,4);
        Preconditions.checkPositionIndex(4,4);
        Preconditions.checkPositionIndexes(1, 2, 2);*/
        /*System.out.println(Objects.equal("", "hhhh"));
        String a = null;
        System.out.println(a =="hh");*/

        //String bb = null;
        //Preconditions.checkNotNull(bb, "s%置为空", bb);
        GuavaTestOne.nanShou("dd", "hh");
        Object s1 = new Object();
        GuavaTestOne guavaTestOne = new GuavaTestOne();
        guavaTestOne.t1();
        try {
            Object o = guavaTestOne.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        String sss = "123456";
        System.out.println(sss.substring(0,4));


    }
}
