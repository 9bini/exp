package me.kbin.exp.serialization;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter @ToString
public class Member implements Serializable {
  private String name;
  private String email;
  private int age;
}
