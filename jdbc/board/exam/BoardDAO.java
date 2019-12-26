package jdbc.board.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//tb_board���̺��� �������ϴ� ����� ���ǵ� Ŭ����
//Ŀ�ؼ��� �� �޼ҵ帶�� �� �־�ߵ�, ����̹��� �� �ѹ��� 
public class BoardDAO {
	public void select() {
		String sql = "select * from tb_board ";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtill.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString("content")+"\t");
				System.out.print(rs.getDate(5)+"\t");
				System.out.println(rs.getInt(6));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			} catch(SQLException e) { 
				e.printStackTrace();
			}
		}
	}
	public void delete(int boardnum) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "delete tb_board where boardnum = ?";
		try {
			con = DBUtill.getConnect();
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, boardnum);
			
			int result = stmt.executeUpdate();
			System.out.println(result+"�� ���� �����ƽ��ϴ�.");
		}catch(SQLException e) {
			System.out.println("���� ����"+e.getMessage());
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			} catch(SQLException e) { 
				e.printStackTrace();
			}
		}

	}
	public void update(String id, int boardnum) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("update tb_board ");
		sql.append("set id = ? ");
		sql.append("where boardnum = ? ");
		
		try {
			con = DBUtill.getConnect();//DBMS�� ����
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(1, id);
			stmt.setInt(2, boardnum);
			
			int result = stmt.executeUpdate();
			System.out.println(result+"�� ���� �����ƽ��ϴ�.");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			} catch(SQLException e) { 
				e.printStackTrace();
			}
		}
	}
	public void insert(String id, String title, String content) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		try {
			con = DBUtill.getConnect();//DBMS����
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, title);
			stmt.setString(3, content);
			int result = stmt.executeUpdate();
			System.out.println(result+"�� �� ���Լ���");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			} catch(SQLException e) { 
				e.printStackTrace();
			}
		}
	}
	
}
