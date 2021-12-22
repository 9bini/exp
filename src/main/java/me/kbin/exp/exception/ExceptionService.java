package me.kbin.exp.exception;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExceptionService {

  @Autowired
  ExceptionRepository exceptionRepository;

  // 록백 X
  public void checkException() {
    try {
      exceptionRepository.save(new ExceptionEntity());
      if (true) {
        throw new IOException();
      }else{
        throw new TimeoutException();
      }

    } catch (IOException | TimeoutException e) {
      e.printStackTrace();
    }
  }

  public void uncheckException() {
    // 록백 됨
    exceptionRepository.save(new ExceptionEntity());
    throw new RuntimeException();
  }
}
