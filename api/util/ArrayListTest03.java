package api.util;
//�ָ� ����. ����X. ����غ���.
import java.util.ArrayList;

public class ArrayListTest03 {
	public static void main(String[] args) {
		String[] arr = {"java","oracle","jdbc","html5","css","java"};
		ArrayList<String> list= changeData(arr);//�޼ҵ��� returnŸ�Կ� �°� ������ �����ϰ� ���� ��������ߵ�. �̰� �޼ҵ� call�� �⺻��.
		//��ȯ�Ǿ� ���ϵ� ArrayList�� ����� ���� ������ ����ϱ�.
		/*
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i));
		} �ٵ� �� ����� ���� for���� ����� �� ���� heap�� list�ȿ� size�� ȣ���ؼ� ����. �������� ���������� ���� ������ �� ������ �Ϸ��� �Ʒ�ó�� ����ߵ�
		
		int size = list.size();
		for(int i = 0; i<size();i++) {
			System.out.println(list.get(i));
		}
		*/
		for (String data : list) {
			System.out.println("���: "+data);
		}
	}
	//�迭�� ArrayList�� ��ȯ�ؼ� �����ϴ� �޼ҵ�
	public static ArrayList<String> changeData(String[] arr){
		ArrayList<String> list = new ArrayList<String>();//�������̴ϱ� �̷��� ����ߵ�
		//�Ű������� ���޵� �迭���� �����͸� ������ ArrayList�� �����ϴ� �ڵ�
		for(int i =0; i<arr.length;i++) {
			 list.add(arr[i]);
		}
		return list;
	}
	
}
