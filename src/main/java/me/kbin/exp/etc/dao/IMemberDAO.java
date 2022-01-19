package me.kbin.exp.etc.dao;


import java.sql.Connection;
import java.util.ArrayList;
import me.kbin.exp.etc.dto.MemberDTO;

public interface IMemberDAO {

  //1.db접속
  Connection getConnection();

  //2.회원등록
  //void registMember(String id, String pw, String name);
  int registMember(MemberDTO member);

  //3.회원정보수정
  int updateMember(MemberDTO member);

  //4.회원정보조회(전체목록보기)
  ArrayList<MemberDTO> getList();
}
