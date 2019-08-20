package study.thread;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/3/25 17:51
 */
public class Sale {

    //public  AtomicInteger ticketNum = new AtomicInteger(100);
    public  volatile int ticketNum = 0;
    public int flag = 0;

    public  void sale() {
        ticketNum++;
            //System.out.println(Thread.currentThread().getName()+"卖第"+ticketNum+"张票！");
        //System.out.println(Thread.currentThread().getName()+"卖第"+a+"张票！");

    }

    public void increase() {
        synchronized (this){

                // wait();
                //Thread.sleep(5000);
                System.out.println("线程11111");

            flag++;
        }

    }

    public void take() {
        synchronized (this) {
            flag=flag*3;
            // notify();
            System.out.println("线程222222");
        }

    }
}
