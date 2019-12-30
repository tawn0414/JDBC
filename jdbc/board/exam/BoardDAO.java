package jdbc.board.exam;

import java.util.ArrayList;

//DBMS와 직접적으로 연동하는 유일한 클래스.
public interface BoardDAO {
	int insert(BoardDTO board);//아래처럼 각각의 컬럼을 엑세스 하는 것이 아니고 이렇게 해주자.
	int insert(String id, String title, String content);//게시글 등록 -C
	int update(String id, int boardNum);//게시글 수정-U
	int delete(int boardNum);//게시글 삭제-D
	ArrayList<BoardDTO> select();//전체 게시글 조회- L(list), 두개 이상의 레코드를 반환하는 select의 데이터 타입은 항상 ArrayList.
	BoardDTO read(int boardNum);// 게시글 하나 조회 -R, primary key물려서 레코드 딱 하나 조회. 레코드가 딱 하나니까 ArrayList에 담을 필요없다.
	ArrayList<BoardDTO> findByTitle(String title);//게시글 검색 - L, 완벽하게 일치하는 것만 가져오는게 아님. 단어하나 쳤을때 이 단어가 포함되는 데이터는 모두 가져옴. 물음표는 값만 대체할 수 있음. where절에서 값이 같은거 비교할때랑 다른거 비교할때를 생각.
}
