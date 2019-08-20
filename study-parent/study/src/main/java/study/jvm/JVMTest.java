package study.jvm;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/19 11:25
 */
public class JVMTest {



    public static void main(String[] args) {
        while (true) {
            new Thread(() -> {String s = new String("hhhh");
                System.out.println(s);})
                    .start();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
