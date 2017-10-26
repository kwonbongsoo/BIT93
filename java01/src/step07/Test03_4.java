/* 초기화 블록 : 생성자 II
 * => 여러 개의 생성자 중에서 호출될 생성자를 지정하기!
 * => 문법
 *      new 클래스명 (아규먼트, ...)
 *      => 인스턴스 생성시키는 명령문에서 어떤 값을 넘기느냐에 따라
 *           호출될 생성자가 결정된다,.
 */
package step07;

public class Test03_4 {
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
      System.out.println("이름 나이 받는 파라미터 생성자 호출");
    }

  }
  
  static class Student2 {
    static String name = "홍길동";  // 변수를 선언할 때 값을 초기화 시키는 문장을 포함할 수 있다.
    int age = 20;
    //단 한 개의 생성자라도 작성하지 않으면 다음과 같은 기본생성자 default constructor 가 생성된다.
    //Student() { }
    
  }
  public static void main(String[] args) {
    new Student(20);
    new Student("홍길동",20);
    new Student();
    new Student2();

  }
}
