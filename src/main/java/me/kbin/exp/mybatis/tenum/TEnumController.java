package me.kbin.exp.mybatis.tenum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mybatis/enum")
public class TEnumController {

  @Autowired
  TEnumMapper mapper;

  @PostMapping
  public void post(@RequestBody TEnumEntity tEnumEntity) {
    mapper.post(tEnumEntity);
  }

  @GetMapping
  public ResponseEntity<TEnumEntity> get() {
    TEnumEntity tEnumEntity = mapper.get(TEnum.S3);
    return new ResponseEntity<>(tEnumEntity, HttpStatus.OK);
  }
}

