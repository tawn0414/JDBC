package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedDeleteTest {
public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedDeleteTest obj = new PreparedDeleteTest();
		System.out.print("삭제할 번호: ");
		int boardnum = key.nextInt();
		obj.delete(boardnum);
	}
	public void delete(int boardnum) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "delete tb_board where boardnum = ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, boardnum);
			
			int result = stmt.executeUpdate();
			System.out.println(result+"개 행이 삭제됐습니다.");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println("연결 실패"+e.getMessage());
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			} catch(SQLException e) { 
				e.printStackTrace();
			}
		}

	}
}
