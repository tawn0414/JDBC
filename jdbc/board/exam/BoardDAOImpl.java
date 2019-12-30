package jdbc.board.exam;
//DAO는 db관련 작업만 하는 클래스.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	//조회한 결과를 ArrayList로 변환하여 리턴.
	public ArrayList<BoardDTO> select() {
		//전체 게시글을 담을 Collection
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();//레코드를 담을 그릇이라서 무조건 만들어 줘야함.
		//조회한 게시글을 담을 객체 => BoardDTO board = null;
		//객체를 생성하지 않고 null로 초기화하는 이유
		//-> 데이터를 조회하는 작업을 하는 곳이 while문 내부이므로 while문에서 조회된 레코드로 객체로 생성
		BoardDTO board = null;
		String sql = "select * from tb_board ";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtill.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				//1. 조회한 레코드의 컬럼을 읽어서 DTO로 변환하는 작업.
				board = new BoardDTO(rs.getInt(1),
						rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6));
				//2. DTO로 변환된 레코드를 ArrayList에 추가
				boardlist.add(board);
				
				/*위에 처럼 안하면 아래처럼 하나하나 해줘야됨.
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString("content")+"\t");
				System.out.print(rs.getDate(5)+"\t");
				System.out.println(rs.getInt(6));*/
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(rs, stmt, con);
		}
		return boardlist;
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
	@Override
	public BoardDTO read(int boardNum) {
		BoardDTO board = null;
		String sql = "select * from tb_board where boardnum = ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtill.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,boardNum);
			rs = stmt.executeQuery();
			if(rs.next()) {//primary key인 boardnum은 한 레코드만 나올꺼니까 while안써도 됨.
				board = new BoardDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			DBUtill.close(rs, stmt, con);
		}
		
		return board;
	}
	@Override
	public ArrayList<BoardDTO> findByTitle(String title) {
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select * from tb_board ");
		sql.append("where TITLE like ?");
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
				
		try {
			con = DBUtill.getConnect();
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, "%"+title+"%");
			rs = stmt.executeQuery();//stmt.executeQuery()이 실행된 결과가 ResultSet에 리턴될꺼에요	
			while(rs.next()) {
				board = new BoardDTO(rs.getInt(1),
						rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6));
				boardlist.add(board);//ArrayList에 추가하기								
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtill.close(rs, stmt, con);
			}
			return boardlist;
	}
}