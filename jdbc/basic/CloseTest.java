package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "select id,title,content from tb_board ";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			//select문을 실행
			rs = stmt.executeQuery(sql);
			//System.out.println("rs:"+rs);
			//ResultSet에 레코드가 존재하는 동안 반복문을 실행할 것이다. java.sql -> ResultSet -> first,next,last등등 있음. 보통 next를 쓰고 나머지는 코드로 구성함.
			while(rs.next()) {// 레코드를 조회하기 위해서는 레코드가 한 개라도 반드시 커서를 이동시켜야 한다. 
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.println(rs.getString("content")+"\t");//컬럼명을 써도됨.
				//System.out.print(rs.getDate(5)+"\t");
				//System.out.println(rs.getInt(6));
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {//exception이 발생하지 않거나 발생하거나 무조건 실행할 명령문을 정의한다.
			//자원반납
			try {
				if(rs!=null)rs.close(); //위에서 con까지만 실행되고 에러나면 stmt랑 rs가 null인 상태임. 그래서 if문 안써주면 close할 때 nullpointexception이 뜰 것임. 
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			} catch(SQLException e) { //close메소드가 이런 예외가 throw되니까 처리해줘야됨.
				e.printStackTrace();
			}
		}
	}
}
