package jdbc.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//���� sql����
public class InsertTest {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		String sql = "insert into tb_board values(board_seq.nextval,'jang','����','����',sysdate,0)";
		String sql1 = "insert into tb_board values(board_seq.nextval,'kang','����','����',sysdate,0)";
		//String sql2 = "insert into tb_board values(1,'kim','����','����',sysdate,0)"; 1 �����ϱ� ������.
		try {
			//1.����Ŭ ����̹� �ε�: �����Ϸ��°� ����Ŭ����̹��Դϴ� ��¶�. (�����غ�)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹��ε� ����");
			//2.DBMS�� �����ϱ�: ���������� �����ϱ�.(�������)
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("���Ἲ��:"+con);
			//3.sql�� �����ϱ� ���� ��ü�� ����: ���������� ������Ѿ� �ϹǷ� Connection��ü�� �̿��ؼ� ����, Connection�� ���������� ��������.
			Statement stmt = con.createStatement();
			System.out.println("SQL�� �����ϱ� ���� ��ü����:"+stmt);//����Ŭ�� �����ϱ� OracleStatementWrapper�� ���� �ִ� ��. statements�� sql�� �����ϴ� ��ü��.
			
			//4.sql�����ϱ�
			int result = stmt.executeUpdate(sql);
			//5. ��� ó���ϱ�
			System.out.println(result+"�� �� ���Լ���");
		}catch(ClassNotFoundException e) {
			System.out.println("����̹��ε� ����");
		}catch(SQLException e) {
			System.out.println("�������:");//���� jang'�̶�� �Է��ϸ� ������ ��.
			e.printStackTrace();//���� �����ϴ� �޼ҵ�
		}
				
	}

}
