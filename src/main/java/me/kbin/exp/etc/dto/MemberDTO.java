package me.kbin.exp.etc.dto;

import lombok.Data;

@Data

public class MemberDTO {

  private String id;
  private String pw;
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }
}
