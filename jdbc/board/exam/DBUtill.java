package jdbc.board.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DBMS에 접근하는 중복된 작업을 정의할 클래스
public class DBUtill {
	//1. 드라이버로딩 작업은 클래스가 로딩될때 같이 로딩되도록 처리한다.
	//=> static{}안의 명령문은 클래스가 로딩될때 한 번만 실행되는 코드. static메모리에 오라클드라이버를 올림.
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2. 커넥션하기: 메소드를 호출하면 DBMS와 접속 후에 접속정보를 저장하고 있는 Connection을 리턴. 객체마다 다른 값을 받는게 아니고 연결시킬꺼니까 static으로 해주자.
	public static Connection getConnect() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {//커넥션을 만들어주는 메소드임.
			con = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	//3. 자원반납: ResultSet, Statement, Connection객체 사용을 해제.
	//         => 각각의 객체를 해제할 수 있도록 메소드를 정의해도 좋다. 우리는 한꺼번에 할 거. 자원을 반납하고 끝낼꺼니까  void
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
		} catch(SQLException e) { 
			e.printStackTrace();
		}
	}
	
}
