package study.thread.batching;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/9/15 09:05
 */
public class RemoteService {

    public List<RemoteResponse> getUserInfo(List<Map<String, Object>> params) {
        List<RemoteResponse> responses = new ArrayList<>();
        for (int i = 0; i < params.size(); i++) {
            RemoteResponse remoteResponse = new RemoteResponse();
            remoteResponse.setName("shuaizi" + i);
            remoteResponse.setPassword("shuaizi" + i);
            remoteResponse.setSerialNumber(params.get(i).get("serialNumber").toString());
            responses.add(remoteResponse);
        }

        for (Map<String, Object> param : params) {
            for (RemoteResponse response : responses) {
                if (param.get("serialNumber").toString().equals(response.getSerialNumber())) {
                    CompletableFuture<RemoteResponse> completableFuture = (CompletableFuture<RemoteResponse>)param.get("fucture");
                    completableFuture.complete(response);
                }
            }
        }
        return responses;
    }

}
