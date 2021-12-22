package me.kbin.exp.idea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MilController {

  @Autowired
  MilService milService;

  @GetMapping
  public void test() {
    List<Mil> mils = new ArrayList<>();
    //실험할 코드 추가

    for (int i = 0; i < 1000000000; i++) {
      mils.add(milService.test());
    }
    long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
    Collections.shuffle(mils);
    for (Mil mil : mils) {
      milService.get(mil.getId());
    }

    long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
    System.out.println("시간차이(m) : " + secDiffTime);
  }
}
