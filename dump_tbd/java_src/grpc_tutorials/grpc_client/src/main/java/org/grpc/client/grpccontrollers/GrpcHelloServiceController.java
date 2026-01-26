package org.grpc.client.grpccontrollers;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.gprc.protodef.messages.helloservice.HelloRequest;
import org.gprc.protodef.messages.helloservice.HelloResponse;
import org.gprc.protodef.services.helloservice.HelloServiceGrpc;
import org.springframework.stereotype.Component;

@Component
public class GrpcHelloServiceController {

  public String testHelloServiceRestController(String firstName, String secondName) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9081)
        .usePlaintext()
        .build();

    HelloServiceGrpc.HelloServiceBlockingStub stub
        = HelloServiceGrpc.newBlockingStub(channel);

    HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
        .setFirstName(firstName)
        .setLastName(secondName)
        .build());


    return helloResponse.getGreeting();
  }
}
