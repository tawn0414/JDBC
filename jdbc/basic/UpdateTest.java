package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* 직접 코딩해서 작업하기
 2번 boardnum의 id를 kang으로 수정.
 [출력 형태]
 1개 행이 수정됐습니다.
 */
public class UpdateTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "update tb_board ";
		sql = sql + "set ID = 'kang' ";
		sql = sql + "where BOARDNUM = 2";//자바언어로 실행하는 DML은 자동으로 commit됨. 그냥 sql작성했을때는 commit을 직접 해줬어야 했음.
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버가 로딩됨");
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
			
			Statement stmt = con.createStatement();
			System.out.println("SQL을 실행하기 위한 객체정보"+stmt);
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result+"개 행이 수정됐습니다.");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println("연결 실패"+e.getMessage());
		}
	}

}
