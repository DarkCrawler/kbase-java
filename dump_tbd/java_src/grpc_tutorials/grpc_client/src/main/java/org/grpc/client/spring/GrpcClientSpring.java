package org.grpc.client.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.grpc.client"})
@EnableAutoConfiguration
public class GrpcClientSpring {
}
