package jdbc.board.exam;

import java.util.ArrayList;

//DBMS�� ���������� �����ϴ� ������ Ŭ����.
public interface BoardDAO {
	int insert(BoardDTO board);//�Ʒ�ó�� ������ �÷��� ������ �ϴ� ���� �ƴϰ� �̷��� ������.
	int insert(String id, String title, String content);//�Խñ� ��� -C
	int update(String id, int boardNum);//�Խñ� ����-U
	int delete(int boardNum);//�Խñ� ����-D
	ArrayList<BoardDTO> select();//��ü �Խñ� ��ȸ- L(list), �ΰ� �̻��� ���ڵ带 ��ȯ�ϴ� select�� ������ Ÿ���� �׻� ArrayList.
	BoardDTO read(int boardNum);// �Խñ� �ϳ� ��ȸ -R, primary key������ ���ڵ� �� �ϳ� ��ȸ. ���ڵ尡 �� �ϳ��ϱ� ArrayList�� ���� �ʿ����.
	ArrayList<BoardDTO> findByTitle(String title);//�Խñ� �˻� - L, �Ϻ��ϰ� ��ġ�ϴ� �͸� �������°� �ƴ�. �ܾ��ϳ� ������ �� �ܾ ���ԵǴ� �����ʹ� ��� ������. ����ǥ�� ���� ��ü�� �� ����. where������ ���� ������ ���Ҷ��� �ٸ��� ���Ҷ��� ����.
}
