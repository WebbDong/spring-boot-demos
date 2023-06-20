package com.webbdong.springboot.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

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

}
