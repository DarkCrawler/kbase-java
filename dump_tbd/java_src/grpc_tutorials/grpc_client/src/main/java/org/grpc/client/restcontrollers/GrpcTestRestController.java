package org.grpc.client.restcontrollers;

import org.grpc.client.grpccontrollers.GrpcHelloServiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcTestRestController {

  @Autowired
  GrpcHelloServiceController grpcHelloServiceController;

  @GetMapping("/helloservice")
  public ResponseEntity<String> testHelloService(@RequestParam String firstName,
                                                 @RequestParam String lastName) {
      return  new ResponseEntity<>(grpcHelloServiceController.testHelloServiceRestController(firstName,lastName), HttpStatus.OK);
  }


}
