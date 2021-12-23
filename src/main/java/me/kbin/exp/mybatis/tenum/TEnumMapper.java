package me.kbin.exp.mybatis.tenum;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TEnumMapper {

  void post(TempEnumEntity tempEnumEntity);
  List<TempEnumEntity> get(TempEnum tempEnum);

}
