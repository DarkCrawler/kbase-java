package com.skibidi.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.skibidi"})
@EnableAutoConfiguration
public class SkibidiSpring {

  @Bean
  public String aSampleTest() {
    System.out.println("Hello man!!");
    return "a random bean";
  }
}
