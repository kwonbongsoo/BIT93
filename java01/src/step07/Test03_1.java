/* 초기화 블록 스태틱 블록
 * => 클래스가 로딩되고 클래스 변수가 준비된 후 자동으로 실행하는 블록
 * => 한 클래스 안에 여러 개의 static 블록을 넣을 수 있다.
 * => 문법
 *      static {...}
 *      주로 클래스 변수를 초기화시키는 코드를 둔다.
 */
package step07;

public class Test03_1 {
  static class Student {
    static String name = "홍길동";  // 변수를 선언할 때 값을 초기화 시키는 문장을 포함할 수 있다.
    static {
      System.out.println(name);
      System.out.println("static...1");
      name = "임꺽정";
      System.out.println("static 1"+name);
    }
    static {
      System.out.println("static...2");
      name = "유관순";
      System.out.println("static 2"+name);
    }
  }
  public static void main(String[] args) {
    Student.name ="하하하";
    System.out.println(Student.name);
  }
}
