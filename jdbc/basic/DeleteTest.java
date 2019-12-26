package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* UpdateTest.java를 rename해서 작업
 * sql문만 delete문으로 변경해서 실행해보기
 * 3번 boardnum의 게시물을 삭제
 * 
 * [출력형태]
 * 1개 행이 삭제됐습니다.
 */
public class DeleteTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		StringBuffer sql = new StringBuffer();
		sql.append("delete tb_board ");
		sql.append("where boardnum = 4");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버가 로딩됨");
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
			
			Statement stmt = con.createStatement();
			System.out.println("SQL을 실행하기 위한 객체정보"+stmt);
			
			int result = stmt.executeUpdate(sql.toString());//append쓰면 타입이 안맞으니까 toString을 해줘야됨.
			System.out.println(result+"개 행이 삭제됐습니다.");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println("연결 실패"+e.getMessage());
		}
	}

}
