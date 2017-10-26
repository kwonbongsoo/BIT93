package step21.ex7;

public class Test02 {
  public static void main(String[] args) {
    B obj;
//    obj = new C(); //C는 추상클래스이다. 인스턴스 생성 불가!
    obj = new D();
    obj.m2();
  }
}
