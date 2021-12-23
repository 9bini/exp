package me.kbin.exp.mybatis.tenum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter
@NoArgsConstructor
@AllArgsConstructor
public class TempEnumEntity {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private Long id;

  @Enumerated(EnumType.STRING)
  private TempEnum esTemp;

}
