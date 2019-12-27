package api.util;
//����ó��,Ʈ������� �߿���. ����ó�� ����(�迭�� ó���� ����� ��������ϰ�, ���ʹ� �� ���� ������ �� �ִ�.)
//���ʹ� ����� ���ְ� ����. ���ְ� ���� ÷�� �⺻���� �뷮�� 10���� �ش�.
import java.util.Vector;
//Vector�� API�ϱ� �޼ҵ� CALL�� �����ؾߵ�.
//Vector�� ����� ����ϴ� ���, <>: genericǥ�� => �÷��� �����ӿ�ũ ���� ������ Ÿ���� ��Ȯ�� ����ؾߵǴµ� �� ������ ���ִ°� generic. ��� �������� �����ϱ�.
//							generic�� reference type�� �� �� �־ int��� �Ⱦ��� integer��� �� ��.
//vector�� ����� ����� ������ vector�� �뷮�� �ʰ��� ������ ������ vector�뷮��ŭ �뷮�� �þ��.
public class VectorTest01 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		//v.add("java");
		v.add(10);
		System.out.println("Vector�� �뷮: "+v.capacity());//�뷮= �� ������
		System.out.println("Vector�� ����� ����� ����: "+v.size());//size:���� �������� ����.
		
		System.out.println("===================================");
		for(int i = 1; i<=10;i++) {
			v.add(i);
		}
		System.out.println("Vector�� �뷮: "+v.capacity());
		System.out.println("Vector�� ����� ����� ����: "+v.size());
		
		System.out.println("===================================");
		for(int i = 1; i<=10;i++) {
			v.add(i);
		}
		System.out.println("Vector�� �뷮: "+v.capacity());
		System.out.println("Vector�� ����� ����� ����: "+v.size());
		
		System.out.println("===================================");
		for(int i = 1; i<=20;i++) {
			v.add(i);
		}
		System.out.println("Vector�� �뷮: "+v.capacity());
		System.out.println("Vector�� ����� ����� ����: "+v.size());
		
		System.out.println("===================================");
		for(int i = 1; i<=40;i++) {
			v.add(i);
		}
		System.out.println("Vector�� �뷮: "+v.capacity());
		System.out.println("Vector�� ����� ����� ����: "+v.size());
	}
}
