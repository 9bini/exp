package me.kbin.exp.mybatis.tenum;

import lombok.Getter;
import me.kbin.exp.codeenum.CodeEnum;
import org.apache.ibatis.type.MappedTypes;

@Getter
enum TEnum implements CodeEnum {
  LOCAL("0001"), S3("0002");

  private final String code;

  TEnum(String code) {
    this.code = code;
  }

  @MappedTypes(TEnum.class)
  public static class TypeHandler extends CodeEnumTypeHandler<TEnum> {

    public TypeHandler() {
      super(TEnum.class);
    }
  }

  @Override
  public String getCode() {
    return code;
  }
}
