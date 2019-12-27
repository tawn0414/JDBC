package api.util;
//동시처리,트랜잭션이 중요함. 동시처리 벡터(배열은 처음에 사이즈를 정해줘야하고, 벡터는 그 점을 보완할 수 있다.)
//벡터는 사이즈를 안주고 들어간다. 안주고 들어가면 첨엔 기본으로 용량을 10개를 준다.
import java.util.Vector;
//Vector는 API니까 메소드 CALL로 접근해야됨.
//Vector를 만들고 사용하는 방법, <>: generic표시 => 컬렉션 프레임워크 쓸땐 데이터 타입을 정확히 명시해야되는데 이 역할을 해주는게 generic. 사용 시점에서 정의하기.
//							generic은 reference type만 쓸 수 있어서 int라고 안쓰고 integer라고 쓴 것.
//vector에 저장된 요소의 갯수가 vector의 용량을 초과할 때마다 이전의 vector용량만큼 용량이 늘어난다.
public class VectorTest01 {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		//v.add("java");
		v.add(10);
		System.out.println("Vector의 용량: "+v.capacity());//용량= 총 사이즈
		System.out.println("Vector에 저장된 요소의 갯수: "+v.size());//size:들어가는 데이터의 갯수.
		
		System.out.println("===================================");
		for(int i = 1; i<=10;i++) {
			v.add(i);
		}
		System.out.println("Vector의 용량: "+v.capacity());
		System.out.println("Vector에 저장된 요소의 갯수: "+v.size());
		
		System.out.println("===================================");
		for(int i = 1; i<=10;i++) {
			v.add(i);
		}
		System.out.println("Vector의 용량: "+v.capacity());
		System.out.println("Vector에 저장된 요소의 갯수: "+v.size());
		
		System.out.println("===================================");
		for(int i = 1; i<=20;i++) {
			v.add(i);
		}
		System.out.println("Vector의 용량: "+v.capacity());
		System.out.println("Vector에 저장된 요소의 갯수: "+v.size());
		
		System.out.println("===================================");
		for(int i = 1; i<=40;i++) {
			v.add(i);
		}
		System.out.println("Vector의 용량: "+v.capacity());
		System.out.println("Vector에 저장된 요소의 갯수: "+v.size());
	}
}
