package FirstExam;

import java.util.Scanner;
public class DAOTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("******�Խ���********");
		System.out.println("1. ȸ�����");
		System.out.println("2. ȸ������ ����");
		System.out.println("3. ȸ�� ����");
		System.out.print("���ϴ� �۾��� �����ϼ���:");
		int choice  = key.nextInt();
		show(choice);
	}
	public static void show(int choice){
		MenuUI ui = new MenuUI();
		switch(choice){
			case 1:
				ui.insertMenu();
				break;
			case 2:
				ui.updateMenu();
				break;
			case 3:
				ui.deleteMenu();
				break;
		}
	}
}













