package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//오라클에 접속하기
public class ConnectionTest {
	//127.0.0.1 = localhost = 현재 작업중인 나의 pc를 의미하는 ip.
	public static void main(String[] args) {
		//연결문자열: 어떤 DBMS를 쓰느냐에 따라 형식이 달라진다.
		//jdbc:oracle:thin:@ip:port:데이터베이스 서비스명,(1521:어플리케이션이 쓰는 포트)
		//String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		//접속계정
		String user = "min";
		//접속할 계정의 패스워드
		String password = "pw";
		try {
			//1.오라클 드라이버 로딩: .class파일이 lock걸려 있기때문에 new 할 수 없다. JVM이 인식할 수 있는 위치로 클래스를 로딩하는 작업.
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			System.out.println("드라이버로딩 성공");
			//2.DBMS에 연결하기: 연결정보를 정의하기. 늘 똑같음
			//==>DBMS에 연결하고 연결정보를 Connection타입으로 반환한다.
			//연결하고 연결정보(연결주소)를 저장해야 statement를 사용할 수 있다.
			//DriverManager: DBMS에 연결하는 역할을 함. 
			//sql 명령 한번당 연결을 한번씩 해줘야됨.
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공:"+con);
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패");
		}catch(SQLException e) {
			System.out.println("연결실패:"+e.getMessage());
		}	
	}
}
