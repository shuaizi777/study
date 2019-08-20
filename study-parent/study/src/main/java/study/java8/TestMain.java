package study.java8;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/4/15 15:08
 */
public class TestMain implements DefaultTestInterface {

    @Override
    public void get() {
        DefaultTestInterface.super.get();
    }

    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.get();
        testMain.print();
        DefaultTestInterface.set();
        System.out.println("hhhhhhhhhh44444444444");
    }
}
