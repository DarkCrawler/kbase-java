package org.grpc.server.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.grpc.server"})
@EnableAutoConfiguration
public class GrpcServerSpring {
}
