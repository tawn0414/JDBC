package jdbc.basic;
/*
step1 insert메소드 작성해서 코드복사
step2 main메소드에서 insert메소드 호출
step3 insert메소드 내부에서 자원반납
step4 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//동적 sql실행
public class PreparedInsertTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		PreparedInsertTest obj = new PreparedInsertTest();
		System.out.println("**********게시글 등록************");
		System.out.print("아이디: ");
		String id = key.next();
		System.out.print("제목: ");
		String title = key.next();
		System.out.print("내용: ");
		String content = key.next();
		obj.insert(id, title, content);
	}

	public void insert(String id, String title, String content) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//sql문법에 맞게 변수를 넣어줘야됨. 예전에는 밑에처럼 했음
		/*String sql = "insert into tb_board values(board_seq.nextval,'"+id+"','"+title+"','"+content+"',sysdate,0)";*/
		String sql = "insert into tb_board values(board_seq.nextval,?,?,?,sysdate,0)"; //이게 동적 sql임. 외부에서 입력받을 값을 물음표로 표시.
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			//1. PreparedStatement생성
			stmt = con.prepareStatement(sql);
			//2. 물음표에 값 전달하기
			stmt.setString(1, id);
			stmt.setString(2, title);
			stmt.setString(3, content);
			//3. 실행하기
			int result = stmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패");
		}catch(SQLException e) {
			System.out.println("연결실패:");
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