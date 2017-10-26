package fun;
//��� �̳� Ŭ����
public class Outer {
	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void output(){
		System.out.println("�̸�:"+name+" ����:"+new Inner().getAge());
	}
	class Inner{
		private int age;
		
		public void setAge(int age){
			this.age = age;
		}
		public int getAge(){
			return age;
		}
		public void disp(){
			System.out.println("�̸�:"+Outer.this.name+" ����:"+this.age);
		}
	}//Inner
	public static void main(String[] args) {
		Outer out = new Outer();
		out.setName("����");
		System.out.println("�̸�:"+out.getName());
		Outer.Inner in = out.new Inner();
		in.setAge(27);
		in.disp();
		
		Outer.Inner in2 = out.new Inner();
		in2.setAge(30);
		in2.disp();
		
		Outer.Inner in3 = new Outer().new Inner();
		in3.setAge(32);
		in3.disp();
		
	}
}
