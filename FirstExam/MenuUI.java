package FirstExam;
import java.util.Scanner;

public class MenuUI {
	Scanner key = new Scanner(System.in);
	CustomerDAO dao = new CustomerDAOImpl();
	public void insertMenu(){
		System.out.println("*******ȸ�����********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("��й�ȣ:");
		String pass = key.next();
		System.out.print("�̸�:");
		String name = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		
		CustomerDTO customer = new CustomerDTO(id, pass, name, addr);
		int result = dao.insert(customer);
		if(result>0) {
			System.out.println("ȸ�� ��� ����");
		}else {
			System.out.println("ȸ�� ��� ����");
		}
	}
	public void updateMenu(){
		System.out.println("*******ȸ������********");
		System.out.print("���̵�:");
		String id = key.next();
		System.out.print("�ּ�:");
		String addr = key.next();
		int result = dao.update(id, addr);
		if(result>0) {
			System.out.println("ȸ�� ���� ����");
		}else {
			System.out.println("ȸ�� ���� ����");
		}
	}
	public void deleteMenu(){
		System.out.println("*******ȸ������********");
		System.out.print("���̵�:");
		String id = key.next();
		int result = dao.delete(id);
		if(result>0) {
			System.out.println("ȸ�� ���� ����");
		}else {
			System.out.println("ȸ�� ���� ����");
		}
	}
}


















