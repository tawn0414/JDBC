package jdbc.board.exam;

import java.util.Scanner;

import jdbc.basic.PreparedDeleteTest;
import jdbc.basic.PreparedInsertTest;
import jdbc.basic.PreparedSelectTest;
import jdbc.basic.PreparedUpdateTest;

public class BoardDAOTest {
	public static void main(String[] args) {
		//insert
		/*
		 * Scanner key = new Scanner(System.in);
		BoardDAO dao = new BoardDAO();
		System.out.println("**********�Խñ� ���************");
		System.out.print("���̵�: ");
		String id = key.next();
		System.out.print("����: ");
		String title = key.next();
		System.out.print("����: ");
		String content = key.next();
		dao.insert(id, title, content);*/
		
		//select
		/*BoardDAO dao = new BoardDAO();
		dao.select();*/
		
		//delete
		/*Scanner key = new Scanner(System.in);
		BoardDAO dao = new BoardDAO();
		System.out.print("������ ��ȣ: ");
		int boardnum = key.nextInt();
		dao.delete(boardnum);
		*/
		
		//update
		Scanner key = new Scanner(System.in);
		BoardDAO dao = new BoardDAO();
		System.out.print("���̵�: ");
		String id = key.next();
		System.out.print("������ ��ȣ: ");
		int boardnum= key.nextInt();
		dao.update(id, boardnum);
	}

}
