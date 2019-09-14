package study.test;

import java.math.BigInteger;
import java.util.Random;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/23 16:51
 */
public class Test {

    public static class StaticClass {

    }


    public static void main(String[] args) {
        StaticClass staticClass = new Test.StaticClass();

        Random random = new Random();
        System.out.println(random.nextDouble());
        //
        BigInteger bigInteger = new BigInteger("4234232353245345345235324532453245345245");

        System.out.println(bigInteger);
    }
}
