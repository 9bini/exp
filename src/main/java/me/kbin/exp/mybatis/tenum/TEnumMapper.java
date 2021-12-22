package me.kbin.exp.mybatis.tenum;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TEnumMapper {

  void post(TEnumEntity tEnumEntity);
  TEnumEntity get(TEnum tEnum);

}
