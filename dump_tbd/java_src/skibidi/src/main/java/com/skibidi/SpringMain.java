package com.skibidi;

import com.skibidi.spring.SkibidiSpring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMain {
  public static void main(String[] args) {
    SpringApplication.run(SkibidiSpring.class, args);
  }
}
