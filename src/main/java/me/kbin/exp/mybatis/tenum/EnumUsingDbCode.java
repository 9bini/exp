package me.kbin.exp.mybatis.tenum;

import com.fasterxml.jackson.annotation.JsonValue;

public interface EnumUsingDbCode {
  @JsonValue
  String getDbCode();
}
