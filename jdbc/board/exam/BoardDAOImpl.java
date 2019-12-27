package jdbc.board.exam;
//DAO�� db���� �۾��� �ϴ� Ŭ����.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//tb_board���̺��� �������ϴ� ����� ���ǵ� Ŭ����
//Ŀ�ؼ��� �� �޼ҵ帶�� �� �־�ߵ�, ����̹��� �� �ѹ��� 
public class BoardDAOImpl implements BoardDAO{
	public int insert(BoardDTO board) {
		System.out.println("dto��� �޼ҵ�:"+board);
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		int result = 0;//�޼ҵ��� �������� ����� ����. 
		try {
			con = DBUtill.getConnect();//DBMS����
			stmt = con.prepareStatement(sql);
			stmt.setString(1, board.getId());
			stmt.setString(2, board.getTitle());
			stmt.setString(3, board.getContent());
			result = stmt.executeUpdate();//�̰� ���������� ����Ǵ� ���
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(null, stmt, con);
		}
		return result; //���� ������ ���� result�� 0�� return��. ������ �� �Ǹ� stmt.executeUpdate()�� return
	}
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
			DBUtill.close(rs, stmt, con);
		}
	}
	public int delete(int boardNum) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "delete tb_board where boardnum = ?";
		int result = 0;
		try {
			con = DBUtill.getConnect();
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, boardNum);
			
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("���� ����"+e.getMessage());
		}finally {
			DBUtill.close(null, stmt, con);
		}
		return result;

	}
	public int update(String id, int boardNum) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("update tb_board ");
		sql.append("set id = ? ");
		sql.append("where boardnum = ? ");
		int result = 0;
		try {
			con = DBUtill.getConnect();//DBMS�� ����
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(1, id);
			stmt.setInt(2, boardNum);
			
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(null, stmt, con);
		}
		return result;
	}
	public int insert(String id, String title, String content) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		int result = 0;//�޼ҵ��� �������� ����� ����. 
		try {
			con = DBUtill.getConnect();//DBMS����
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, title);
			stmt.setString(3, content);
			result = stmt.executeUpdate();//�̰� ���������� ����Ǵ� ���
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(null, stmt, con);
		}
		return result; //���� ������ ���� result�� 0�� return��. ������ �� �Ǹ� stmt.executeUpdate()�� return
	}
	
}
