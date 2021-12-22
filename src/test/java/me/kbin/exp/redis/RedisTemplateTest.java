package me.kbin.exp.redis;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
class RedisTemplateTest {

  @Autowired
  StringRedisTemplate redisTemplate;

  @Test
  void stringTemplate() {
    String key = "string";
    ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
    valueOperations.set(key, "1");
    String one = valueOperations.get(key);
    Assertions.assertEquals("1", one);

    valueOperations.increment(key);
    String incr = valueOperations.get(key);
    Assertions.assertEquals("2", incr);
  }

  @Test
  void listTemplate() {
    String key = "list";
    ListOperations<String, String> listOperations = redisTemplate.opsForList();
    redisTemplate.delete(key);

    listOperations.rightPush(key, "L");
    listOperations.rightPush(key, "i");
    listOperations.rightPush(key, "s");
    listOperations.rightPush(key, "t");

    listOperations.rightPushAll(key, "t", "e", "m", "p", "l", "a", "t", "e");

    String L = listOperations.index(key, 0);
    Assertions.assertEquals("L", L);

    Long size = listOperations.size(key);
    Assertions.assertEquals(12, size);

    List<String> range = listOperations.range(key, 0, 9);
    log.info(Arrays.toString(range.toArray()));

  }

  @Test
  void set() {
    String key = "set";
    SetOperations<String, String> setOperations = redisTemplate.opsForSet();
    redisTemplate.delete(key);
    setOperations.add(key, "s", "e", "t");

    Set<String> members = setOperations.members(key);
    Assertions.assertEquals(3, members.size());

    Long size = setOperations.size(key);
    Assertions.assertEquals(3, size);
    try (Cursor<String> cursor = setOperations.scan(key,
        ScanOptions.scanOptions().match("*").count(3).build());) {
      while (cursor.hasNext()) {
        log.info(cursor.next());
      }
    }
  }

  @Test
  void sortedSet() {
    String key = "sortedSet";
    ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
    redisTemplate.delete(key);

    zSetOperations.add(key, "S",1);
    zSetOperations.add(key, "t",3);
    zSetOperations.add(key, "z",0);
    zSetOperations.add(key, "e",2);

    Set<String> range = zSetOperations.range(key, 0, 3);

    log.info(Arrays.toString(range.toArray()));
    Long size = zSetOperations.size(key);
    Assertions.assertEquals(4, size);



  }
}
