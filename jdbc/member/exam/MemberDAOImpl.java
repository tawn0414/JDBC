package jdbc.member.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.board.exam.BoardDTO;
import jdbc.board.exam.DBUtill;

public class MemberDAOImpl implements MemberDAO{
	public int insert(MemberDTO member) {
		System.out.println("dto사용 메소드: "+member);
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "insert into member values(?,?,?,?,?,sysdate,1000)";
		int result = 0;//메소드의 실행결과가 저장될 변수. 
		try {
			con = DBUtill.getConnect();//DBMS연결
			stmt = con.prepareStatement(sql);
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPass());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getAddr());
			stmt.setString(5, member.getDeptno());
			result = stmt.executeUpdate();//이게 최종적으로 수행되는 결과
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(null, stmt, con);
		}
		return result;
	}
	
	public int delete(String id) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "delete member where id = ?";
		int result = 0;
		try {
			con = DBUtill.getConnect();
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, id);
			
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("연결 실패"+e.getMessage());
		}finally {
			DBUtill.close(null, stmt, con);
		}
		return result;

	}
	
	public int update(String id, String addr) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuffer sql = new StringBuffer();
		sql.append("update member ");
		sql.append("set addr = ? ");
		sql.append("where id = ? ");
		int result = 0;
		try {
			con = DBUtill.getConnect();//DBMS에 연결
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(1, addr);
			stmt.setString(2, id);
			
			result = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(null, stmt, con);
		}
		return result;
	}

	@Override
	public ArrayList<MemberDTO> memberList() {
		ArrayList<MemberDTO> boardlist = new ArrayList<MemberDTO>();
		MemberDTO board = null;
		String sql = "select * from member ";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
			
		try {
			con = DBUtill.getConnect();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
						board = new MemberDTO(rs.getString(1),
								rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getInt(7));					
						boardlist.add(board);						
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtill.close(rs, stmt, con);
			}
			return boardlist;
	}

	@Override
	public ArrayList<MemberDTO> findByAddr(String addr) {
		ArrayList<MemberDTO> boardlist = new ArrayList<MemberDTO>();
		MemberDTO mem = null;
		String sql = "select * from member where addr like ?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DBUtill.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+addr+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				mem = new MemberDTO(rs.getString(1),
						rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getInt(7));					
				boardlist.add(mem);						
		}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtill.close(rs, stmt, con);
		}
		return boardlist;
	}

	@Override
	public MemberDTO login(String id, String pass) {
		MemberDTO board = null;
		String sql = "select * from member where id = ? and pass =?";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtill.getConnect();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
						board = new MemberDTO(rs.getString(1),
								rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6),rs.getInt(7));												
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtill.close(rs, stmt, con);
			}
		return board;
	}
}
