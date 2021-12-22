package me.kbin.exp.session;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.kbin.exp.codeenum.UserType;

@AllArgsConstructor
@Getter @ToString
@NoArgsConstructor
public class TestVO implements Serializable {

  private Long id;
  private String email;
  private int price;
  private UserType userType;
}
