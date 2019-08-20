package study.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/5/20 21:58
 */
public class AlipayTest {
    public static void main(String[] args) throws AlipayApiException, InterruptedException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2016093000631252", "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCElMMeSe+H6LGguMdLgJLB+g/ldqqfFHVUulf1RCG22VheBDHQSmZikDzIka+r77F9TkPiqqU/oEJyuj6rj4lVn10iy0QcOf/JynYnvAwFG5c4YEmAnDe/tXoxZhpYThTKLz/W0xxdwPpE2Nhd1hDJ/6VD6yv8X19Op7nuXxXUmmsuPm7k1wJGXWs2tHkBSalEoAjxkE8xd3PzOE2UeHKVtMG3HXjQcgTDcnkQZKiJWgJ7jC2uvxlxrjnTi2ASRIPpi8MJoO1JKcSw0GaDU6QWKRoHB6WP5IdJoY6U7OEOEPK/cZ5vQAbhmPz99JbrwZFRiuRw/vx8JTkGZiGO3EXNAgMBAAECggEAaDoOvkP/k4eiBKjevANi3C26y3ijn5XUu3wW49Dg9D8fUiHYC1hB7yBXOJIXWYKAtPKPOaVPbZqOQmUaGYMowvAaptzHOa164edRReF2TZmoIwDHJ90nkoWXfzg2Y89WVrAYbsjeFvI7jV4vkm1UG4jnImLB3JAZe9sttzB3F//+by64YlKMM28dkJ8FTjdpXEn9t5h0Oex5KL4KEttXHzDOuLxJCvy4YpOD2OeVVY7nifhmO2noxwRbqAa2HphGDlPuXBdc22fFwbxNlUE5v0hA7nxCulOB/89P6P5MKd3fA7V9RndYo7Jpbb+CbfJMoLnX/nKMt+1G8hRa8GJDAQKBgQDKQQ8YPmJMeo0skO4PLlmx/nATLSyq+pBl8lS8jJ9/38FkyyOxldAFnCLkbTFzBi0TRXED7lTsl+v0gtVPXzc5rYeOLTn+rwztePL4fs5bf0D61zlg2BgtwXNfl1ecE89txHg1UdSLM8EzkOFVt28IEsW4vQvulfwNGeaCsC5ajQKBgQCnz/y5FTeBmTbPyfXTlGpvaZaw4EnYFlzx9pPctjE8E/8R7JyWrpoW42WrhZ0GQMQER6bDCVoM4upwx+WpPdRytnBf+HZpBo9B7n/njtCG3IzSujeNYmrYK+CmqzBJafckMHYeax/kOndNFbfcn2mQWbvZvYbTtiRT3JTxGwZoQQKBgQCrzbP6zhNGD9wX/UybTK4Yip+9SmRlIM7EKqNcPr/GKdXnvr8lPLMl8Mma7D5TDO4BLr2frzYoe6yNWQ3FjIYm0ocReM2I0D3VAyaxe1XjVydlbKlq4GU5iNhuXOqoxBMxlPDfqhE35dC58tnWrCj+3KNkGAIouvMOVe//F5VoiQKBgHnwko3TMwBDWybmdHEIWccXjN5+PGp+5Y8VRCCPa3tidGiL7MU5ntKe7pQShSW0Djul7TGwK/VNNlo5h1LRkPzCQSobm795esPIEL0sc65ruRCvLAraxxTJ3XZ+0pmmHGX5qPs1kHkBWwtyiqYQWF8CNZRlOgHBSuh9UuVYY/GBAoGAOsuAFzvJ/RpENswixj3xDimIjFm/xHucYf3SOyaDcxD88NB/LBU6qtlQ++s0sPsgyFou+qJa1F+VeAvPN9adjr7/pcRNptZ9BCYQOpkhvZUpSNCLmCLYPJss3oNPcdKuzSRNd4nS2ZWkZpDRo40stSV3uzBv/fEezDdimHdmVHk=",
                "json", "utf-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtBMAtvXO++BhrqE1/x5qwMaHo9PDY+tBVZaciTgVJLEbiCeFhHO5jUley3VP+Pxlbk4YmCUDK5ImaZPfLjBd8dmrEhVwi8ZEcCTscDgnv/659vFMp2fkrnXqTwex6hk0Vv21y/HbAjsK6SCXJW1ILv9Gogbd1it0C+bMnT/PXSYgWcLxspqy+ISocKMy/zxqfW/hU/dgwPtl+2H1GrKGWlo4sC/levBwXxJn6R3QR+5LiTisF9DJDwVdsj5LICT9jrLbBW2PQOBnOih7g5oRiyiXujCUi+3geMRS4UBIQ+myCgXjvHG0fhhKTZRlBYhOkbyZnbE6B2nQHe7Q7UFpRQIDAQAB", "RSA2"); //获得初始化的AlipayClient
        // 1.发起预下单请求
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
        request.setBizContent("{" +
                "    \"out_trade_no\":\"20150320010101027\"," +
                "    \"total_amount\":\"88.88\"," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"store_id\":\"NJ_001\"," +
                "    \"timeout_express\":\"90m\"}");//设置业务参数
        AlipayTradePrecreateResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.print(response.getBody());
        // 2.查询交易状态
        AlipayTradeQueryRequest requestTwo = new AlipayTradeQueryRequest();
        requestTwo.setBizContent("{" +
                "\"out_trade_no\":\"20150320010101027\"," +
                "\"trade_no\":\"\"," +
                "\"org_pid\":\"\"" +
                "  }");
        AlipayTradeQueryResponse responseTwo = null;
        while (true) {
            Thread.sleep(3000);
            responseTwo = alipayClient.execute(requestTwo);
            System.out.println(responseTwo.getBody());
            if (responseTwo.isSuccess()) {
                System.out.println(responseTwo.getTradeStatus());
                if (responseTwo.getTradeStatus().equals("TRADE_SUCCESS")) {
                    System.out.println("ok了");
                    break;
                }
            } else {
                System.out.println("调用失败");
            }
        }

    }
}
