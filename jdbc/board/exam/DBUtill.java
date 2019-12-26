package jdbc.board.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DBMS�� �����ϴ� �ߺ��� �۾��� ������ Ŭ����
public class DBUtill {
	//1. ����̹��ε� �۾��� Ŭ������ �ε��ɶ� ���� �ε��ǵ��� ó���Ѵ�.
	//=> static{}���� ��ɹ��� Ŭ������ �ε��ɶ� �� ���� ����Ǵ� �ڵ�. static�޸𸮿� ����Ŭ����̹��� �ø�.
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2. Ŀ�ؼ��ϱ�: �޼ҵ带 ȣ���ϸ� DBMS�� ���� �Ŀ� ���������� �����ϰ� �ִ� Connection�� ����. ��ü���� �ٸ� ���� �޴°� �ƴϰ� �����ų���ϱ� static���� ������.
	public static Connection getConnect() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {//Ŀ�ؼ��� ������ִ� �޼ҵ���.
			con = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
