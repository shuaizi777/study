package study.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/3/23 10:26
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread thread = new Thread(()-> {System.out.println("我是子线程");});
        thread.start();
        thread.join();
        System.out.println("i am main thread!");
        System.out.println("******************");

        CallableTest callableTest = new CallableTest();
        FutureTask<Integer> futureTask = new FutureTask<>(callableTest);
        Thread thread2 =new Thread(futureTask);
        thread2.start();
        System.out.println(futureTask.get());
        System.out.println("*************************");

        Thread thread3 = new Thread("nihao");
        thread3.start();
    }

}
