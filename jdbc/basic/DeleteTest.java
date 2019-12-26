package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* UpdateTest.java�� rename�ؼ� �۾�
 * sql���� delete������ �����ؼ� �����غ���
 * 3�� boardnum�� �Խù��� ����
 * 
 * [�������]
 * 1�� ���� �����ƽ��ϴ�.
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
			System.out.println("����̹��� �ε���");
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("���Ἲ��");
			
			Statement stmt = con.createStatement();
			System.out.println("SQL�� �����ϱ� ���� ��ü����"+stmt);
			
			int result = stmt.executeUpdate(sql.toString());//append���� Ÿ���� �ȸ����ϱ� toString�� ����ߵ�.
			System.out.println(result+"�� ���� �����ƽ��ϴ�.");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		}catch(SQLException e) {
			System.out.println("���� ����"+e.getMessage());
		}
	}

}
