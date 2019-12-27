package jdbc.board.exam;

public interface BoardDAO {
	int insert(BoardDTO board);//아래처럼 각각의 컬럼을 엑세스 하는 것이 아니고 이렇게 해주자.
	int insert(String id, String title, String content);
	int update(String id, int boardNum);
	int delete(int boardNum);
	void select();
}
