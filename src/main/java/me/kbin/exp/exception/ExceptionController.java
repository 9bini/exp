package me.kbin.exp.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

  @Autowired
  ExceptionService exceptionService;

  @GetMapping
  public String exceptionTest(){
    exceptionService.checkException();
    exceptionService.uncheckException();
    return "test";
  }

}
