package org.grpc.server.services;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.gprc.protodef.messages.helloservice.HelloRequest;
import org.gprc.protodef.messages.helloservice.HelloResponse;
import org.gprc.protodef.services.helloservice.HelloServiceGrpc;

@GrpcService
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {
  @Override
  public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    String greeting = new StringBuilder()
        .append("Hello, ")
        .append(request.getFirstName())
        .append(" ")
        .append(request.getLastName())
        .toString();

    HelloResponse response = HelloResponse.newBuilder()
        .setGreeting(greeting)
        .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
