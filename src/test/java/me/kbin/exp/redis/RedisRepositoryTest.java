package me.kbin.exp.redis;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import me.kbin.exp.codeenum.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
class RedisRepositoryTest {

  @Autowired
  RedisVoRepository redisVoRepository;

  @Test
  void test(){
    RedisVo vo = new RedisVo(1L, "name2", UserType.ADMIN);
    RedisVo saveVo = redisVoRepository.save(vo);

    Optional<RedisVo> findVo = redisVoRepository.findById(saveVo.getId());

    Assertions.assertTrue(findVo.isPresent());
    Assertions.assertEquals(findVo.get().getName(), vo.getName());
  }

}
