package me.kbin.exp.etc.dao;


import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import me.kbin.exp.etc.dto.MemberDTO;

public class MemberDAO implements IMemberDAO {

  @Override
  public Connection getConnection() {
    Connection conn = null;

    try {
      // 1.드라이버 로딩
      Class.forName("oracle.jdbc.OracleDriver");
      // 2.연결객체 생성(db주소, 계정이름, 패스워드)
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

    } catch (ClassNotFoundException e) {
      System.out.println("ojdbc8.jar파일을 추가하세요.");
    } catch (SQLException e) {
      System.out.println("db 연결 정보(주소, id, pw)를 확인하세요.");
    }

    return conn;
  }

  @Override
  public int registMember(MemberDTO member) {
    //회원 등록

    //db연결
    Connection conn = getConnection();

    System.out.println("사용자 등록 합니다.");
    Scanner sc = new Scanner(System.in);
    System.out.println("아이디를 입력하세요 : ");
    String id = sc.nextLine();
    System.out.println("패스워드를 입력하세요 : ");

    String pw = sc.nextLine();

    System.out.println("이름을 입력하세요 : ");
    String name = sc.nextLine();
    if (id == null) {
      System.out.println("null값이 들어있습니다. 그래서 종료 합니다.");
      return 0;
    }

		byte[] bytes = pw.getBytes(StandardCharsets.US_ASCII);

		String encodingPw = new String();
		for(int i = 0; i < bytes.length; i++) {
			encodingPw += bytes[i];
			encodingPw+=" ";
		}

    String sql = "insert into t_member values ('" + id + "', '" + encodingPw + "', '" + name + "')";

    int result = 0;
    try {
      Statement stmt = conn.createStatement();
      result = stmt.executeUpdate(sql);

      if (result > 0) {
        System.out.println("등록 성공!!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;
  }

  @Override//미구현
  public int updateMember(MemberDTO member) {

    Connection conn = getConnection();

    return 0;
  }

  @Override
  public ArrayList<MemberDTO> getList() {
    ArrayList<MemberDTO> mlist = new ArrayList<MemberDTO>();
    //ArrayList(배열) 생성완료 이름이 mlist		//리스트 안에는 MEmber dto 만 들어가짐

    Connection conn = getConnection();

    String sql = "select * from T_member ORDER BY id ";
    System.out.println("내가 작성한 select 문 결과 :    " + sql);

    try {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {

        MemberDTO Member = new MemberDTO();
        Member.setId(rs.getString("id"));
				String[] splits = rs.getString("pw").split(" ");
				String decodingPw = new String();
				for (String s : splits) {
					decodingPw += Character.toString((char) Integer.parseInt(s));
				}
        Member.setPw(decodingPw);
        Member.setName(rs.getString("name"));
        mlist.add(Member);

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return mlist;
  }


}
	


