package me.kbin.exp.etc.client;


import java.sql.Connection;
import me.kbin.exp.etc.dao.MemberDAO;
import me.kbin.exp.etc.dto.MemberDTO;

public class regTest {
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
/*					insert 문                                       	*/
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		//test 용 MemberDTO 객체 를 넣어 준다.
		MemberDTO member = new MemberDTO();
	
		
		Connection con = dao.getConnection();
		int n = dao.registMember(member); 
		if(n > 0) {
			System.out.println("등록성공...Test 클래스");
		}
	}

}
