package com.webbdong.springboot.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: Test.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TestServiceGrpc {

  private TestServiceGrpc() {}

  public static final String SERVICE_NAME = "protobuf.TestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.webbdong.springboot.grpc.Test.MsgRequest,
      com.webbdong.springboot.grpc.Test.MsgResponse> getGetMsgMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "get_msg",
      requestType = com.webbdong.springboot.grpc.Test.MsgRequest.class,
      responseType = com.webbdong.springboot.grpc.Test.MsgResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.webbdong.springboot.grpc.Test.MsgRequest,
      com.webbdong.springboot.grpc.Test.MsgResponse> getGetMsgMethod() {
    io.grpc.MethodDescriptor<com.webbdong.springboot.grpc.Test.MsgRequest, com.webbdong.springboot.grpc.Test.MsgResponse> getGetMsgMethod;
    if ((getGetMsgMethod = TestServiceGrpc.getGetMsgMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getGetMsgMethod = TestServiceGrpc.getGetMsgMethod) == null) {
          TestServiceGrpc.getGetMsgMethod = getGetMsgMethod =
              io.grpc.MethodDescriptor.<com.webbdong.springboot.grpc.Test.MsgRequest, com.webbdong.springboot.grpc.Test.MsgResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "get_msg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.webbdong.springboot.grpc.Test.MsgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.webbdong.springboot.grpc.Test.MsgResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("get_msg"))
              .build();
        }
      }
    }
    return getGetMsgMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TestServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceStub>() {
        @java.lang.Override
        public TestServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceStub(channel, callOptions);
        }
      };
    return TestServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceBlockingStub>() {
        @java.lang.Override
        public TestServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceBlockingStub(channel, callOptions);
        }
      };
    return TestServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceFutureStub>() {
        @java.lang.Override
        public TestServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceFutureStub(channel, callOptions);
        }
      };
    return TestServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TestServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getMsg(com.webbdong.springboot.grpc.Test.MsgRequest request,
        io.grpc.stub.StreamObserver<com.webbdong.springboot.grpc.Test.MsgResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMsgMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMsgMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.webbdong.springboot.grpc.Test.MsgRequest,
                com.webbdong.springboot.grpc.Test.MsgResponse>(
                  this, METHODID_GET_MSG)))
          .build();
    }
  }

  /**
   */
  public static final class TestServiceStub extends io.grpc.stub.AbstractAsyncStub<TestServiceStub> {
    private TestServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceStub(channel, callOptions);
    }

    /**
     */
    public void getMsg(com.webbdong.springboot.grpc.Test.MsgRequest request,
        io.grpc.stub.StreamObserver<com.webbdong.springboot.grpc.Test.MsgResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMsgMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TestServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TestServiceBlockingStub> {
    private TestServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.webbdong.springboot.grpc.Test.MsgResponse getMsg(com.webbdong.springboot.grpc.Test.MsgRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMsgMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TestServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TestServiceFutureStub> {
    private TestServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.webbdong.springboot.grpc.Test.MsgResponse> getMsg(
        com.webbdong.springboot.grpc.Test.MsgRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMsgMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MSG = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TestServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TestServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MSG:
          serviceImpl.getMsg((com.webbdong.springboot.grpc.Test.MsgRequest) request,
              (io.grpc.stub.StreamObserver<com.webbdong.springboot.grpc.Test.MsgResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.webbdong.springboot.grpc.Test.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TestService");
    }
  }

  private static final class TestServiceFileDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier {
    TestServiceFileDescriptorSupplier() {}
  }

  private static final class TestServiceMethodDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TestServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TestServiceFileDescriptorSupplier())
              .addMethod(getGetMsgMethod())
              .build();
        }
      }
    }
    return result;
  }
}
