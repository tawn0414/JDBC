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
			//select���� ����
			rs = stmt.executeQuery(sql);
			//System.out.println("rs:"+rs);
			//ResultSet�� ���ڵ尡 �����ϴ� ���� �ݺ����� ������ ���̴�. java.sql -> ResultSet -> first,next,last��� ����. ���� next�� ���� �������� �ڵ�� ������.
			while(rs.next()) {// ���ڵ带 ��ȸ�ϱ� ���ؼ��� ���ڵ尡 �� ���� �ݵ�� Ŀ���� �̵����Ѿ� �Ѵ�. 
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.println(rs.getString("content")+"\t");//�÷����� �ᵵ��.
				//System.out.print(rs.getDate(5)+"\t");
				//System.out.println(rs.getInt(6));
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {//exception�� �߻����� �ʰų� �߻��ϰų� ������ ������ ��ɹ��� �����Ѵ�.
			//�ڿ��ݳ�
			try {
				if(rs!=null)rs.close(); //������ con������ ����ǰ� �������� stmt�� rs�� null�� ������. �׷��� if�� �Ƚ��ָ� close�� �� nullpointexception�� �� ����. 
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			} catch(SQLException e) { //close�޼ҵ尡 �̷� ���ܰ� throw�Ǵϱ� ó������ߵ�.
				e.printStackTrace();
			}
		}
	}
}
