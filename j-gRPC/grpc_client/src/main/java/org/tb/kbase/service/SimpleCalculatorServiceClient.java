package org.tb.kbase.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;
import org.tb.grpc.samples.AddRequest;
import org.tb.grpc.samples.AddResponse;
import org.tb.grpc.samples.CalculatorServiceGrpc;


@Component
public class SimpleCalculatorServiceClient {
    public void simpleCalculate() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext() // no TLS for now
                .build();

        CalculatorServiceGrpc.CalculatorServiceBlockingStub stub =
                CalculatorServiceGrpc.newBlockingStub(channel);


        AddRequest request = AddRequest.newBuilder()
                .setA(10)
                .setB(20)
                .build();

        AddResponse response = stub.add(request);

        System.out.println("Result from server: " + response.getResult());

        channel.shutdown();


    }
}


//NOTES : ManagedChannel ?