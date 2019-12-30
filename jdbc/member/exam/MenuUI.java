package jdbc.member.exam;
import java.util.ArrayList;
import java.util.Scanner;

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
		ArrayList<MemberDTO> mem = dao.findByAddr(addr);
		int size = mem.size();
		for(int i = 0; i<size; i++) {
			MemberDTO board = mem.get(i);
			System.out.print("id:"+board.getId()+"\t");
			System.out.print("pass:"+board.getPass()+"\t");
			System.out.print("name:"+board.getName()+"\t");
			System.out.print("addr:"+board.getAddr()+"\t");
			System.out.print("deptno:"+board.getDeptno()+"\t");
			System.out.print("hiredate:"+board.getHiredate()+"\t");
			System.out.println("point:"+board.getPoint());
		}
	}
	
	
	public void selectMenu(){
		System.out.println("*******사원조회********");
		//여기에서 EmpDAO의 메소드를 호출하세요 - 전체사원조회
		ArrayList<MemberDTO> boardlist = dao.memberList();
		int size = boardlist.size();
		for(int i = 0; i<size;i++) {
			MemberDTO board = boardlist.get(i);
			System.out.print("id:"+board.getId()+"\t");
			System.out.print("pass:"+board.getPass()+"\t");
			System.out.print("name:"+board.getName()+"\t");
			System.out.print("addr:"+board.getAddr()+"\t");
			System.out.print("deptno:"+board.getDeptno()+"\t");
			System.out.print("hiredate:"+board.getHiredate()+"\t");
			System.out.println("point:"+board.getPoint());
		}
	}
	
	public void loginMenu() {
		System.out.println("*******로그인*********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("비밀번호:");
		String pass = key.next();
		MemberDTO result = dao.login(id, pass);
		if(result == null) {
			System.out.println("조회된 데이터가 없습니다.");
		}else {
			System.out.println("로그인 성공");
		}
	}
}


















