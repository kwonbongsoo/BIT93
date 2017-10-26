package step10.ex5;

public class C extends B{
  @Override
  public void m1() {
    System.out.println("C.m1()");
  }
  @Override //자바 컴파일러에게 전달하는 특별한 주석이다. 오버라이딩 여부를 검사하라는 명령!
  public void m2() {
    System.out.println("C.m2()");
  }
}
