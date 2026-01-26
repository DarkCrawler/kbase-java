package org.grpc.client;

import org.grpc.client.spring.GrpcClientSpring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcClientMain {
  public static void main(String[] args) {
    SpringApplication.run(GrpcClientSpring.class, args);
  }
}
