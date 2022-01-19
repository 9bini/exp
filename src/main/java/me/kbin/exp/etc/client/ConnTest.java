package me.kbin.exp.etc.client;

import java.sql.Connection;
import me.kbin.exp.etc.dao.MemberDAO;


public class ConnTest {
public static void main(String[] args) {
	MemberDAO mDao  = new MemberDAO();
	Connection con = mDao.getConnection();
	if(con != null) {
		System.out.println("DB 접속 성공!");
	}else {
		System.out.println("DB 접속 실패");
	}
	
}
}
