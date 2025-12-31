package org.tb.kbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tb.kbase.service.SimpleCalculatorServiceClient;

import javax.annotation.Resource;

public class KbaseGrpcClientMain {


    public static void main(String[] args) {
        // SpringApplication.run(KbaseGrpcClientMain.class, args);
        SimpleCalculatorServiceClient calcClient = new SimpleCalculatorServiceClient();

        calcClient.simpleCalculate();

    }
}