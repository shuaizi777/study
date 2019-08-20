package study.java8;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/4/15 15:06
 */
public interface DefaultTestInterface {

    default void print() {
        System.out.println("first");
    }

    default void get() {
        System.out.println("second");
    }

    static void set() {
        System.out.println("33333");
    }
}
