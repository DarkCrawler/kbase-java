package org.tb.grpc.services;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.tb.grpc.samples.AddRequest;
import org.tb.grpc.samples.AddResponse;
import org.tb.grpc.samples.CalculatorServiceGrpc;

@GrpcService //generated for spring boot
public class SimpleCalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {
    public void add(AddRequest request, StreamObserver<AddResponse> responseObserver) {
        int result = request.getA() + request.getB();

        AddResponse response = AddResponse.newBuilder()
                .setResult(result)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}


//NOTES ON StreamObserver<AddResponse> responseObserver

/*




 */

//NOTES ON net.devh.boot.grpc.server.service.GrpcService; -- what it brings with springboot

