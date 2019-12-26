package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//정적 sql실행
public class InsertTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "insert into tb_board values(board_seq.nextval,'jang','연습','연습',sysdate,0)";
		String sql1 = "insert into tb_board values(board_seq.nextval,'kang','연습','연습',sysdate,0)";
		//String sql2 = "insert into tb_board values(1,'kim','연습','연습',sysdate,0)"; 1 넣으니까 에러뜸.
		try {
			//1.오라클 드라이버 로딩: 연결하려는게 오라클드라이버입니다 라는뜻. (연결준비)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩 성공");
			//2.DBMS에 연결하기: 연결정보를 정의하기.(연결시작)
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공:"+con);
			//3.sql을 실행하기 위한 객체를 생성: 연결정보와 연결시켜야 하므로 Connection객체를 이용해서 생성, Connection이 연결정보를 갖고있음.
			Statement stmt = con.createStatement();
			System.out.println("SQL을 실행하기 위한 객체정보:"+stmt);//오라클꺼 썼으니까 OracleStatementWrapper를 갖고 있는 것. statements가 sql을 실행하는 객체임.
			
			//4.sql실행하기
			int result = stmt.executeUpdate(sql);
			//5. 결과 처리하기
			System.out.println(result+"개 행 삽입성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패");
		}catch(SQLException e) {
			System.out.println("연결실패:");//위에 jang'이라고 입력하면 오류가 남.
			e.printStackTrace();//오류 추적하는 메소드
		}
				
	}

}
