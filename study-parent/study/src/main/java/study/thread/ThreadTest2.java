package study.thread;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/3/25 18:46
 */
public class ThreadTest2  {

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 200; j++) {


            Sale sale = new Sale();

            Thread s1 = new Thread(() -> {
                for (int i = 0; i < 1; i++) {
                    sale.sale();
                    sale.increase();
                }
            }, "窗口1");

            Thread s2 = new Thread(() -> {
                for (int i = 0; i < 1; i++) {
                    sale.sale();
                    sale.take();
                }
            }, "窗口2");

            s1.start();
            s2.start();

            s1.join();
            s2.join();

            //System.out.println(sale.ticketNum);
            //System.out.println(sale.flag);




        }
    }
}
