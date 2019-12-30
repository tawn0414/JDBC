package api.util;

import java.util.ArrayList;

public class ArrayListExam02 {
	public static void main(String[] args) {
		/*번호     성명     자바     웹     android
		 * 1     장동건     97   100    88     => 내가 담아야할 데이터가 여러개 인데 타입이 다르면 DTO를 정의한다.
		 * 2     이민호     100  92     91
		 * 3     류준열     88   96     78 
		 */
		//ArrayList에 데이터 저장하기
		ArrayList<StudentDTO> stdlist = new ArrayList<StudentDTO>();
		StudentDTO std1 = new StudentDTO(1, "장동건", 97, 100, 88);
		StudentDTO std2 = new StudentDTO(2, "이민호", 100, 92, 91);
		StudentDTO std3 = new StudentDTO(3, "류준열", 88, 96, 78);
		
		stdlist.add(std1);
		stdlist.add(std2);
		stdlist.add(std3);
		display(stdlist);
	}
	
	//매개변수로 전달받은 ArrayList에 저장된 데이터를 꺼내서 출력하기
	public static void display(ArrayList<StudentDTO> stdlist) {
		int size = stdlist.size();
		for(int i=0; i<size;i++) {
			StudentDTO std = stdlist.get(i);//stdlist안에 있는 데이터의 데이터타입 써주는거 잊지말기.
			System.out.print("번호: "+std.getNumber()+",");
			System.out.print("이름: "+std.getName()+",");
			System.out.print("자바: "+std.getJava()+",");
			System.out.print("웹: "+std.getWep()+",");
			System.out.println("안드로이드: "+std.getAndroid()+",");
			//ResultSet은 DBMS의 table이다.
			//ResultSet에 있는 데이터를 가공하고 변환하는 작업을 잘 해야함.
			//변환: ResultSet에 있는 내가 원하는 데이터를 ArrayList에 담아서 다른 클래스로 넘긴다.
			//담을때 데이터 타입이 모두 같은것이 아니니까 위에 처럼 ArrayList에 DTO를 담는다.
		}
	}
}
