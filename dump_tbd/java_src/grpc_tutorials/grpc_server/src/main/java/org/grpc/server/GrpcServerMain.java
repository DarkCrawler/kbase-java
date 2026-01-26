package org.grpc.server;

import org.grpc.server.spring.GrpcServerSpring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GrpcServerMain {
  public static void main(String[] args) {
    SpringApplication.run(GrpcServerSpring.class, args);
  }
}
