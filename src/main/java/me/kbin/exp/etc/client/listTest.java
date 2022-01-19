package me.kbin.exp.etc.client;


import java.util.ArrayList;
import me.kbin.exp.etc.dao.MemberDAO;
import me.kbin.exp.etc.dto.MemberDTO;

public class listTest {
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
/*				select 	 문      *출력 오류*                            	*/
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
	//1. MemberDAO 클래스의 getConnection()의 메서드를 실행시켜 결과를 테스트 한다.
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO();
		
		ArrayList<MemberDTO> n = dao.getList();
		System.out.println(n); 
		
	}

}
