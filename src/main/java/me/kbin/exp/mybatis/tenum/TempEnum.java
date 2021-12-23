package me.kbin.exp.mybatis.tenum;

import me.kbin.exp.codeenum.CodeEnum;
import org.apache.ibatis.type.MappedTypes;

public enum TempEnum implements CodeEnum {
  LOCAL("000A"),
  S3("0002A");

  private final String code;

  TempEnum(String code) {
    this.code = code;
  }

  @MappedTypes(TempEnum.class)
  public static class TypeHandler extends CodeEnumTypeHandler<TempEnum> {
    public TypeHandler() {
      super(TempEnum.class);
    }
  }

  @Override
  public String getCode() {
    return code;
  }
}
