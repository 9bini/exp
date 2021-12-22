package me.kbin.exp.codeenum;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enum")
public class ApiServerController {

  @GetMapping
  public ResponseEntity<MyRequest> get(){
    MyRequest myRequest = new MyRequest(UserType.ADMIN);
    return new ResponseEntity<>(myRequest, HttpStatus.CREATED);
  }

  @PostMapping
  public ResponseEntity<Void> post(@RequestBody MyRequest myRequest){
    System.out.println(myRequest.getUserType());
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
