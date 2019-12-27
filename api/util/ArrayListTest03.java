package api.util;
//주말 과제. 제출X. 고민해보기.
import java.util.ArrayList;

public class ArrayListTest03 {
	public static void main(String[] args) {
		String[] arr = {"java","oracle","jdbc","html5","css"};
		ArrayList<String> list= changeData(arr);//메소드의 return타입에 맞게 변수를 선언하고 값을 저장해줘야됨. 이게 메소드 call의 기본임.
		//변환되어 리턴된 ArrayList에 저장된 값을 꺼내서 출력하기.
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	//배열을 ArrayList로 변환해서 리턴하는 메소드
	public static ArrayList<String> changeData(String[] arr){
		ArrayList<String> list = new ArrayList<String>();//참조형이니까 이렇게 해줘야됨
		//매개변수로 전달된 배열에서 데이터를 꺼내서 ArrayList에 저장하는 코드
		for(int i =0; i<arr.length;i++) {
			 list.add(arr[i]);
		}
		return list;
	}
	
}
