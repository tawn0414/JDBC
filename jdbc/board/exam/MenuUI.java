package jdbc.board.exam;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	BoardDAO dao = new BoardDAOImpl();
	
	public void insertMenu(){
		System.out.println("*******게시글등록********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("제목:");
		String title = key.next();
		System.out.print("내용:");
		String content = key.next();
		//여기에서 BoardDAO의 메소드를 호출하세요
		//int result = dao.insert(id, title, content);
		BoardDTO board = new BoardDTO(id, title, content);
		int result = dao.insert(board);
		//결과처리
		if(result>0) {
			System.out.println("게시글 등록 성공");
		}else {
			System.out.println("글 등록 실패");
		}
	}
	public void updateMenu(){
		System.out.println("*******게시글수정********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("게시글번호:");
		int boardNum = key.nextInt();
		//여기에서 BoardDAO의 메소드를 호출하세요
		int result = dao.update(id, boardNum);
		if(result>0) {
			System.out.println("게시글 수정 성공");
		}else {
			System.out.println("글 수정 실패");
		}
	}
	public void deleteMenu(){
		System.out.println("*******게시글삭제********");
		System.out.print("게시글번호:");
		int boardNum = key.nextInt();
		//여기에서 BoardDAO의 메소드를 호출하세요
		int result = dao.delete(boardNum);
		if(result>0) {
			System.out.println("게시글 삭제 성공");
		}else {
			System.out.println("글 삭제 실패");
		}
	}
	public void readMenu(){
		System.out.println("*******게시글상세조회********");
		System.out.print("게시글번호:");
		int boardNum = key.nextInt();
		//여기에서 BoardDAO의 메소드를 호출하세요
		BoardDTO result = dao.read(boardNum);//BoardDTO는 dao.read(boardNum)의 return 타입과 동일.
		if(result == null) {//테이블에 없는 게시글번호를 입력하면 NullPointException이 뜨니까 이렇게 처리해준것.
			System.out.println("조회된 데이터가 없습니다.");
		}else {
		System.out.println("글번호:"+result.getBoardNum());
		System.out.println("제목:"+result.getTitle());
		System.out.println("작성자:"+result.getId());
		System.out.println("내용:"+result.getContent());
		System.out.println("작성 날짜:"+result.getWriteDate());
		System.out.println("조회수:"+result.getHit());
		}
	}
	
	public void findByTitleMenu() {
		System.out.println("********제목 검색********");
		System.out.println("제목:");
		String title = key.next();
		ArrayList<BoardDTO> find = dao.findByTitle(title);
		int size = find.size();
		for(int i = 0; i<size; i++) {
			BoardDTO board = find.get(i);
			System.out.println(board.getBoardNum()+"\t"+board.getTitle()+"\t"+board.getId()+"\t"+board.getHit());
		}
	}
	
	
	public void selectMenu(){
		System.out.println("*******게시글조회********");
		//여기에서 BoardDAO의 메소드를 호출하세요 - 전체사원조회
		//ArrayListExam02랑 같은 내용.
		ArrayList<BoardDTO> boardlist = dao.select();
		int size = boardlist.size();
		for(int i = 0; i<size; i++) {
			BoardDTO board = boardlist.get(i);
			System.out.println(board.getBoardNum()+"\t"+board.getTitle()+"\t"+board.getId()+"\t"+board.getHit());
		}
	}
}


















