package com.webbdong.springboot.grpc;

import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.concurrent.TimeUnit;

/**
 * @author WebbDong
 * @createTime 2023-06-20 13:12
 */
@GrpcService
public class TestServiceGrpcImpl extends TestServiceGrpc.TestServiceImplBase {

    @Override
    public void getMsg(Test.MsgRequest request, StreamObserver<Test.MsgResponse> responseObserver) {
        System.out.println(request);
        Test.MsgResponse response = Test.MsgResponse.newBuilder()
                .setMsg("Response : " + System.currentTimeMillis())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @SneakyThrows
    @Override
    public void getMsgServerStream(Test.MsgRequest request, StreamObserver<Test.MsgResponse> responseObserver) {
        for (int i = 0; i < 10; i++) {
            Test.MsgResponse response = Test.MsgResponse.newBuilder()
                    .setCode(String.valueOf(i))
                    .setData("Data" + i)
                    .setMsg("Success")
                    .build();
            responseObserver.onNext(response);
            TimeUnit.SECONDS.sleep(5);
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<Test.MsgRequest> getMsgClientStream(StreamObserver<Test.MsgResponse> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(Test.MsgRequest msgRequest) {
                // 读取客户端的数据
                System.out.println(msgRequest);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // 客户端数据读取完毕，在此可以进行数据的返回
                responseObserver.onNext(Test.MsgResponse.newBuilder()
                        .setMsg("success")
                        .setData("Data")
                        .setCode("000000")
                        .build());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<Test.MsgRequest> getMsgTwoWayStream(StreamObserver<Test.MsgResponse> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(Test.MsgRequest msgRequest) {
                System.out.println(msgRequest);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                for (int i = 0; i < 10; i++) {
                    responseObserver.onNext(Test.MsgResponse.newBuilder()
                            .setCode("000000")
                            .setData("Data" + i)
                            .setMsg("success")
                            .build());
                }
                responseObserver.onCompleted();
            }
        };
    }

}
