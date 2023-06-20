package com.webbdong.springboot.grpc.test;

import com.webbdong.springboot.GrpcClientApp;
import com.webbdong.springboot.grpc.Test.MsgRequest;
import com.webbdong.springboot.grpc.Test.MsgResponse;
import com.webbdong.springboot.grpc.TestServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * @author WebbDong
 * @createTime 2023-06-20 13:38
 */
@SpringBootTest(classes = GrpcClientApp.class)
public class TestServiceGrpcTest {

    // TestServiceBlockingStub只能访问普通单次grpc调用和服务端流的grpc调用
    // 并且所有的方法都有responseObserver参数
    @GrpcClient("testServiceClient")
    private TestServiceGrpc.TestServiceBlockingStub blockingTestService;

    @GrpcClient("testServiceClient")
    private TestServiceGrpc.TestServiceStub testService;

    @Test
    public void testBlockingGetMsg() {
        MsgRequest request = MsgRequest.newBuilder()
                .setName("Ferrari")
                .build();
        MsgResponse response = blockingTestService.getMsg(request);
        System.out.println(response.getMsg());
    }

    @Test
    public void testBlockingGetMsgServerStream() {
        MsgRequest request = MsgRequest.newBuilder()
                .setName("Lamborghini")
                .build();
        Iterator<MsgResponse> iter = blockingTestService.getMsgServerStream(request);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @SneakyThrows
    @Test
    public void testGetMsg() {
        MsgRequest request = MsgRequest.newBuilder()
                .setName("Ferrari")
                .build();
        testService.getMsg(request, new StreamObserver<>() {
            @Override
            public void onNext(MsgResponse msgResponse) {
                System.out.println(msgResponse);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });
        TimeUnit.SECONDS.sleep(5);
    }

    @SneakyThrows
    @Test
    public void testGetMsgServerStream() {
        MsgRequest request = MsgRequest.newBuilder()
                .setName("Ferrari")
                .build();
        testService.getMsgServerStream(request, new StreamObserver<>() {
            @Override
            public void onNext(MsgResponse msgResponse) {
                System.out.println(msgResponse);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });
        TimeUnit.SECONDS.sleep(5);
    }

    @SneakyThrows
    @Test
    public void testGetMsgClientStream() {
        // 用于处理响应数据
        StreamObserver<MsgResponse> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(MsgResponse msgResponse) {
                System.out.println(msgResponse);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        };
        // requestObserver用于处理请求数据
        StreamObserver<MsgRequest> requestObserver = testService.getMsgClientStream(responseObserver);
        for (int i = 0; i < 10; i++) {
            requestObserver.onNext(MsgRequest.newBuilder()
                    .setName("Request" + i)
                    .build());
        }
        requestObserver.onCompleted();
        TimeUnit.SECONDS.sleep(5);
    }

    @SneakyThrows
    @Test
    public void testGetMsgTwoWayStream() {
        // 用于处理响应数据
        StreamObserver<MsgResponse> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(MsgResponse msgResponse) {
                System.out.println(msgResponse);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        };
        StreamObserver<MsgRequest> requestObserver = testService.getMsgTwoWayStream(responseObserver);
        for (int i = 0; i < 10; i++) {
            requestObserver.onNext(MsgRequest.newBuilder()
                    .setName("Request" + i)
                    .build());
        }
        requestObserver.onCompleted();
        TimeUnit.SECONDS.sleep(5);
    }

}
