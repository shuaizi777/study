package study.thread;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/30 19:39
 */
public class SaleThread extends Thread {

    private Sale sale;

    public SaleThread (Sale sale) {
        this.sale = sale;
    }

    @Override
    public void run() {

    }
}
