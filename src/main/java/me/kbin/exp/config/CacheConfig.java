package me.kbin.exp.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
public class CacheConfig {

  @Bean
  public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
    RedisCacheConfiguration redisCacheConfig = RedisCacheConfiguration
        .defaultCacheConfig() // 캐쉬 기본 구성
        // 캐쉬 역/직질화
        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
            // Json 직렬화
            new GenericJackson2JsonRedisSerializer()));
    // key 별로 TtL 기간 설정
    Map<String, RedisCacheConfiguration> redisCacheConfigMap = new HashMap<>();
    redisCacheConfigMap.put("post", redisCacheConfig.entryTtl(Duration.ofHours(1)));
    redisCacheConfigMap.put("feed", redisCacheConfig.entryTtl(Duration.ofSeconds(5L)));

    return RedisCacheManager.builder(connectionFactory)
//        .cacheDefaults(redisCacheConfig)
        .withInitialCacheConfigurations(redisCacheConfigMap)
        .build();
  }
}
