package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//����Ŭ�� �����ϱ�
public class ConnectionTest {
	//127.0.0.1 = localhost = ���� �۾����� ���� pc�� �ǹ��ϴ� ip.
	public static void main(String[] args) {
		//���Ṯ�ڿ�: � DBMS�� �����Ŀ� ���� ������ �޶�����.
		//jdbc:oracle:thin:@ip:port:�����ͺ��̽� ���񽺸�,(1521:���ø����̼��� ���� ��Ʈ)
		//String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String url = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
		//���Ӱ���
		String user = "min";
		//������ ������ �н�����
		String password = "pw";
		try {
			//1.����Ŭ ����̹� �ε�: .class������ lock�ɷ� �ֱ⶧���� new �� �� ����. JVM�� �ν��� �� �ִ� ��ġ�� Ŭ������ �ε��ϴ� �۾�.
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			System.out.println("����̹��ε� ����");
			//2.DBMS�� �����ϱ�: ���������� �����ϱ�. �� �Ȱ���
			//==>DBMS�� �����ϰ� ���������� ConnectionŸ������ ��ȯ�Ѵ�.
			//�����ϰ� ��������(�����ּ�)�� �����ؾ� statement�� ����� �� �ִ�.
			//DriverManager: DBMS�� �����ϴ� ������ ��. 
			//sql ��� �ѹ��� ������ �ѹ��� ����ߵ�.
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("���Ἲ��:"+con);
		}catch(ClassNotFoundException e) {
			System.out.println("����̹��ε� ����");
		}catch(SQLException e) {
			System.out.println("�������:"+e.getMessage());
		}	
	}
}
