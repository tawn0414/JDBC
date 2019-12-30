package jdbc.board.exam;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	BoardDAO dao = new BoardDAOImpl();
	
	public void insertMenu(){
		System.out.println("*******�Խñ۵��********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("����:");
		String title = key.next();
		System.out.print("����:");
		String content = key.next();
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ���
		//int result = dao.insert(id, title, content);
		BoardDTO board = new BoardDTO(id, title, content);
		int result = dao.insert(board);
		//���ó��
		if(result>0) {
			System.out.println("�Խñ� ��� ����");
		}else {
			System.out.println("�� ��� ����");
		}
	}
	public void updateMenu(){
		System.out.println("*******�Խñۼ���********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�Խñ۹�ȣ:");
		int boardNum = key.nextInt();
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.update(id, boardNum);
		if(result>0) {
			System.out.println("�Խñ� ���� ����");
		}else {
			System.out.println("�� ���� ����");
		}
	}
	public void deleteMenu(){
		System.out.println("*******�Խñۻ���********");
		System.out.print("�Խñ۹�ȣ:");
		int boardNum = key.nextInt();
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ���
		int result = dao.delete(boardNum);
		if(result>0) {
			System.out.println("�Խñ� ���� ����");
		}else {
			System.out.println("�� ���� ����");
		}
	}
	public void readMenu(){
		System.out.println("*******�Խñۻ���ȸ********");
		System.out.print("�Խñ۹�ȣ:");
		int boardNum = key.nextInt();
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ���
		BoardDTO result = dao.read(boardNum);//BoardDTO�� dao.read(boardNum)�� return Ÿ�԰� ����.
		if(result == null) {//���̺� ���� �Խñ۹�ȣ�� �Է��ϸ� NullPointException�� �ߴϱ� �̷��� ó�����ذ�.
			System.out.println("��ȸ�� �����Ͱ� �����ϴ�.");
		}else {
		System.out.println("�۹�ȣ:"+result.getBoardNum());
		System.out.println("����:"+result.getTitle());
		System.out.println("�ۼ���:"+result.getId());
		System.out.println("����:"+result.getContent());
		System.out.println("�ۼ� ��¥:"+result.getWriteDate());
		System.out.println("��ȸ��:"+result.getHit());
		}
	}
	
	public void findByTitleMenu() {
		System.out.println("********���� �˻�********");
		System.out.println("����:");
		String title = key.next();
		ArrayList<BoardDTO> find = dao.findByTitle(title);
		int size = find.size();
		for(int i = 0; i<size; i++) {
			BoardDTO board = find.get(i);
			System.out.println(board.getBoardNum()+"\t"+board.getTitle()+"\t"+board.getId()+"\t"+board.getHit());
		}
	}
	
	
	public void selectMenu(){
		System.out.println("*******�Խñ���ȸ********");
		//���⿡�� BoardDAO�� �޼ҵ带 ȣ���ϼ��� - ��ü�����ȸ
		//ArrayListExam02�� ���� ����.
		ArrayList<BoardDTO> boardlist = dao.select();
		int size = boardlist.size();
		for(int i = 0; i<size; i++) {
			BoardDTO board = boardlist.get(i);
			System.out.println(board.getBoardNum()+"\t"+board.getTitle()+"\t"+board.getId()+"\t"+board.getHit());
		}
	}
}


















