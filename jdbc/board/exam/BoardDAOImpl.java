package jdbc.board.exam;
//DAO는 db관련 작업만 하는 클래스.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//tb_board테이블을 엑세스하는 기능이 정의된 클래스
//커넥션은 각 메소드마다 다 있어야됨, 드라이버는 딱 한번만 
public class BoardDAOImpl implements BoardDAO{
	public int insert(BoardDTO board) {
		System.out.println("dto사용 메소드:"+board);
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)";
		int result = 0;//메소드의 실행결과가 저장될 변수. 
		try {
			con = DBUtill.getConnect();//DBMS연결
			stmt = con.prepareStatement(sql);
			stmt.setString(1, board.getId());
			stmt.setString(2, board.getTitle());
			stmt.setString(3, board.getContent());
			result = stmt.executeUpdate();//이게 최종적으로 수행되는 결과
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(null, stmt, con);
		}
		return result; //실행 에러가 나면 result는 0이 return됨. 실행이 잘 되면 stmt.executeUpdate()가 return
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
			System.out.println("연결 실패"+e.getMessage());
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
			con = DBUtill.getConnect();//DBMS에 연결
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
		int result = 0;//메소드의 실행결과가 저장될 변수. 
		try {
			con = DBUtill.getConnect();//DBMS연결
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, title);
			stmt.setString(3, content);
			result = stmt.executeUpdate();//이게 최종적으로 수행되는 결과
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(null, stmt, con);
		}
		return result; //실행 에러가 나면 result는 0이 return됨. 실행이 잘 되면 stmt.executeUpdate()가 return
	}
	
}
