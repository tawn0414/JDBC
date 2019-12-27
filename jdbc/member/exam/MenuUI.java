package jdbc.member.exam;
import java.util.Scanner;

import jdbc.board.exam.BoardDAO;
import jdbc.board.exam.BoardDAOImpl;
import jdbc.board.exam.BoardDTO;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	MemberDAO dao = new MemberDAOImpl();
	public void insertMenu(){
		//입사일은 오늘 날짜(sysdate하라는 말), point = 1000이 삽입되도록 하기.
		System.out.println("*******사원등록********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		System.out.print("성명:");
		String name = key.next();
		System.out.print("주소:");
		String addr = key.next();
		System.out.print("부서번호:");
		String deptno = key.next();
		MemberDTO member = new MemberDTO(id, pass, name, addr, deptno);
		int result = dao.insert(member);
		if(result>0) {
			System.out.println("게시글 등록 성공");
		}else {
			System.out.println("글 등록 실패");
		}
	}
	public void updateMenu(){//아이디 입력받아서 주소변경
		System.out.println("*******사원수정********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("주소:");
		String addr = key.next();
		int result = dao.update(id, addr);
		if(result>0) {
			System.out.println("게시글 수정 성공");
		}else {
			System.out.println("글 수정 실패");
		}
	}
	public void deleteMenu(){//아이디 입력받아서 삭제
		System.out.println("*******사원삭제********");
		System.out.print("아이디:");
		String id = key.next();
		int result = dao.delete(id);
		if(result>0) {
			System.out.println("게시글 삭제 성공");
		}else {
			System.out.println("글 삭제 실패");
		}

	}
	public void findByAddrMenu(){
		System.out.println("*******사원검색********");
		System.out.print("주소:");
		String addr = key.next();
		//여기에서 EmpDAO의 메소드를 호출하세요
	}
	
	
	public void selectMenu(){
		System.out.println("*******사원조회********");
		//여기에서 EmpDAO의 메소드를 호출하세요 - 전체사원조회
	}
}


















