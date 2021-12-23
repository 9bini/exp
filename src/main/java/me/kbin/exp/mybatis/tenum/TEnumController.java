package me.kbin.exp.mybatis.tenum;

import java.util.List;
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
  public ResponseEntity<TempEnumEntity> post(@RequestBody TempEnumEntity tempEnumEntity) {
    mapper.post(tempEnumEntity);
    return new ResponseEntity<>(tempEnumEntity, HttpStatus.OK);
  }

  @GetMapping()
  public ResponseEntity<List<TempEnumEntity>> get() {
    List<TempEnumEntity> tempEnumEntity = mapper.get(TempEnum.S3);
    return new ResponseEntity<>(tempEnumEntity, HttpStatus.OK);
  }


}

