package me.kbin.exp.codeenum;

import com.fasterxml.jackson.annotation.JsonValue;

public interface CodeEnum {
  @JsonValue
  String getCode();

}
