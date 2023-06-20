package com.webbdong.springboot.grpc.test;

import com.webbdong.springboot.GrpcClientApp;
import com.webbdong.springboot.grpc.Test.MsgRequest;
import com.webbdong.springboot.grpc.Test.MsgResponse;
import com.webbdong.springboot.grpc.TestServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author WebbDong
 * @createTime 2023-06-20 13:38
 */
@SpringBootTest(classes = GrpcClientApp.class)
public class TestServiceGrpcTest {

    @GrpcClient("testServiceClient")
    private TestServiceGrpc.TestServiceBlockingStub testService;

    @Test
    public void testGrpcClient() {
        MsgRequest request = MsgRequest.newBuilder()
                .setName("Ferrari")
                .build();
        MsgResponse response = testService.getMsg(request);
        System.out.println(response.getMsg());
    }

}
