package jdbc.board.exam;
//DAO�� db���� �۾��� �ϴ� Ŭ����.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	//��ȸ�� ����� ArrayList�� ��ȯ�Ͽ� ����.
	public ArrayList<BoardDTO> select() {
		//��ü �Խñ��� ���� Collection
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();//���ڵ带 ���� �׸��̶� ������ ����� �����.
		//��ȸ�� �Խñ��� ���� ��ü => BoardDTO board = null;
		//��ü�� �������� �ʰ� null�� �ʱ�ȭ�ϴ� ����
		//-> �����͸� ��ȸ�ϴ� �۾��� �ϴ� ���� while�� �����̹Ƿ� while������ ��ȸ�� ���ڵ�� ��ü�� ����
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
				//1. ��ȸ�� ���ڵ��� �÷��� �о DTO�� ��ȯ�ϴ� �۾�.
				board = new BoardDTO(rs.getInt(1),
						rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6));
				//2. DTO�� ��ȯ�� ���ڵ带 ArrayList�� �߰�
				boardlist.add(board);
				
				/*���� ó�� ���ϸ� �Ʒ�ó�� �ϳ��ϳ� ����ߵ�.
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
			if(rs.next()) {//primary key�� boardnum�� �� ���ڵ常 ���ò��ϱ� while�Ƚᵵ ��.
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
			rs = stmt.executeQuery();//stmt.executeQuery()�� ����� ����� ResultSet�� ���ϵɲ�����	
			while(rs.next()) {
				board = new BoardDTO(rs.getInt(1),
						rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6));
				boardlist.add(board);//ArrayList�� �߰��ϱ�								
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtill.close(rs, stmt, con);
			}
			return boardlist;
	}
}