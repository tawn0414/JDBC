package jdbc.board.exam;

public interface BoardDAO {
	int insert(BoardDTO board);//�Ʒ�ó�� ������ �÷��� ������ �ϴ� ���� �ƴϰ� �̷��� ������.
	int insert(String id, String title, String content);
	int update(String id, int boardNum);
	int delete(int boardNum);
	void select();
}
