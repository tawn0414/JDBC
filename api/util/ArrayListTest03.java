package api.util;
//주말 과제. 제출X. 고민해보기.
import java.util.ArrayList;

public class ArrayListTest03 {
	public static void main(String[] args) {
		String[] arr = {"java","oracle","jdbc","html5","css","java"};
		ArrayList<String> list= changeData(arr);//메소드의 return타입에 맞게 변수를 선언하고 값을 저장해줘야됨. 이게 메소드 call의 기본임.
		//변환되어 리턴된 ArrayList에 저장된 값을 꺼내서 출력하기.
		/*
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i));
		} 근데 이 방법을 쓰면 for문이 실행될 때 마다 heap의 list안에 size를 호출해서 느림. 웹에서는 동시접속이 많기 때문에 더 빠르게 하려면 아래처럼 해줘야됨
		
		int size = list.size();
		for(int i = 0; i<size();i++) {
			System.out.println(list.get(i));
		}
		*/
		for (String data : list) {
			System.out.println("요소: "+data);
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
