package me.kbin.exp.mybatis.onetomany;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OneToMMapper {

  List<OneToM> get(Long id);
}
