package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* ���� �ڵ��ؼ� �۾��ϱ�
 2�� boardnum�� id�� kang���� ����.
 [��� ����]
 1�� ���� �����ƽ��ϴ�.
 */
public class UpdateTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "update tb_board ";
		sql = sql + "set ID = 'kang' ";
		sql = sql + "where BOARDNUM = 2";//�ڹپ��� �����ϴ� DML�� �ڵ����� commit��. �׳� sql�ۼ��������� commit�� ���� ������ ����.
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹��� �ε���");
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("���Ἲ��");
			
			Statement stmt = con.createStatement();
			System.out.println("SQL�� �����ϱ� ���� ��ü����"+stmt);
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result+"�� ���� �����ƽ��ϴ�.");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		}catch(SQLException e) {
			System.out.println("���� ����"+e.getMessage());
		}
	}

}
