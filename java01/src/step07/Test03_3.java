/* 초기화 블록 : 생성자
 * => 인스턴스 생성 --> 인스턴스 블록 실행 --> 생성자 호출
 * => 인스턴스 블록과의 차이점
 *      파라미터를 받아서 인스턴스 변수를 특정 값으로 촉화 시킬 수 있다.
 * => 여러 개의 생성자를 가질 수 있다.
 *      다만, 그 중에서 한 개만 호출 된다.
 *      new 명령어 작성 시에 호출되는 생성자를 개발자가 지정해야 한다.
 * 
 */
package step07;

public class Test03_3 {
  static class Student {
    static String name = "홍길동";  // 변수를 선언할 때 값을 초기화 시키는 문장을 포함할 수 있다.
    int age = 20;
    static { //스태틱 블록은 클래스 로딩 할때 단 한번 쓰인다.
      System.out.println("{static...}");
    }
    { //인스턴스 블록
      System.out.println("{인스턴스 블록 실행1}");
    }
    {
      System.out.println("{인스턴스 블록 실행2}");
    }
    Student() {
      //기본생성자 파라미터가 없는것을 기본생성자 default constructor라 부른다.
      System.out.println("기본 생성자 호출");
    }
    Student(int age) {
      System.out.println("파라미터 age 생성자 호출");
    }
    Student(String name, int age) {
      
    }

  }
  public static void main(String[] args) {
    new Student(20);
    System.out.println("-----------------------");
    new Student();
    
    
  }
}
