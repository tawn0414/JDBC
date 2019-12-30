package api.util;

public class StudentDTO {
	private int number;
	private String name;
	private int java;
	private int wep;
	private int android;
	
	public StudentDTO() {
		
	}

	public StudentDTO(int number, String name, int java, int wep, int android) {
		super();
		this.number = number;
		this.name = name;
		this.java = java;
		this.wep = wep;
		this.android = android;
	}

	@Override//������ ���� ������ Ȯ���ؾ��ϴϱ� �׻� �̰� ������
	public String toString() {
		return "StudentDTO [number=" + number + ", name=" + name + ", java=" + java + ", wep=" + wep + ", android="
				+ android + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getWep() {
		return wep;
	}

	public void setWep(int wep) {
		this.wep = wep;
	}

	public int getAndroid() {
		return android;
	}

	public void setAndroid(int android) {
		this.android = android;
	}
	
	
}

