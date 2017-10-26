package fun;

public class Outer1 {
	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void disp(){
		class Inner1{
			private int age;
			
			public void setAge(int age){
				this.age=age;
			}
			public int getAge(){
				return age;
			}
			public void output(){
				System.out.println("�̸�:"+name+" ����:"+age);
			}
		}
		Inner1 in = new Inner1();
		in.setAge(23);
		in.output();
	}
	public static void main(String[] args) {
		Outer1 out = new Outer1();
		out.setName("�˽÷�");
		out.disp();
	}
}