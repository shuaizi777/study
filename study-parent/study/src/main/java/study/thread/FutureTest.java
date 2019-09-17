package study.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/9/14 19:33
 */
public class FutureTest {

    public static void main(String[] args) throws Exception {

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("hhhhhh");
            return 100;
        });
      /*  CompletableFuture<Integer> future2 = new CompletableFuture<>();
        future2.complete(100);
        future2.get();*/
        future.whenComplete((v, e) -> {
            System.out.println(v);
            System.out.println(e);
        });
        future.get();
        System.out.println(Thread.currentThread().getName());

    }
}
