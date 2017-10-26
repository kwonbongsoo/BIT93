package step10.ex01;
//오버라이딩 : 수퍼클래스의 메서드를 서브클래스의 역할에 맞게 재정의 하는것.
public class Test01 {

  public static void main(String[] args) {
    BitStudent s = new BitStudent();
    s.name = "홍길동";
    s.age = 20;
    s.school = "비트대학교";
    s.print();
    
  }
}
