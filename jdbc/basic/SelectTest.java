package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@70.12.115.52:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "select id,title,content from tb_board ";
		try {//Connection객체로부터 Statement객체가 만들어지고 Statement객체로부터 ResultSet객체가 만들어진다. 자원반납은 역순으로!
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			//select문을 실행
			ResultSet rs = stmt.executeQuery(sql);
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
		}
		
	}

}
