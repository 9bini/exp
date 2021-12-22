package me.kbin.exp.redis;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kbin.exp.codeenum.UserType;
import org.springframework.data.redis.core.RedisHash;

@Getter
@RedisHash("vo")
@AllArgsConstructor
@NoArgsConstructor
public class RedisVo {
  @Id
  private Long id;
  private String name;
  private UserType userType;

}
