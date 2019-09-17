package study.thread.batching;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/9/15 09:17
 */
public class LocalService {

       public CountDownLatch countDownLatch = new CountDownLatch(1000);
       public RemoteService remoteService = new RemoteService();
       public LinkedBlockingQueue<Map<String, Object>> linkedBlockingQueue = new LinkedBlockingQueue<>();


    public  void localCompute() {
        Map<String, Object> param = new HashMap<>();
        param.put("serialNumber", UUID.randomUUID().toString());
        linkedBlockingQueue.add(param);
    }

    public static void main (String[] args) throws Exception {
        LocalService localService = new LocalService();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i <1000 ; i++) {
            executorService.execute(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                localService.countDownLatch.countDown();
                CompletableFuture<RemoteResponse> completableFuture = new CompletableFuture<>();
                Map<String, Object> param = new HashMap<>();
                param.put("serialNumber", UUID.randomUUID().toString());
                param.put("fucture", completableFuture);
                localService.linkedBlockingQueue.add(param);
                try {
                    RemoteResponse remoteResponse = completableFuture.get();
                    System.out.println(remoteResponse + param.get("serialNumber").toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            List<Map<String, Object>> params = new ArrayList<>();
            while (localService.linkedBlockingQueue.size() > 0) {
                params.add(localService.linkedBlockingQueue.poll());
            }
            localService.remoteService.getUserInfo(params);
        }, 1, 2, TimeUnit.SECONDS);
    }


}
