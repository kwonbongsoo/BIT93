/* 초기화 블록 : 생성자 III
 * => 클래스는 여러 개의 생성자를 가질 수 있다.
 * => 파라미터의 개수나 파라미터의 타입 , 파라미터 순서로 구분된다.
 * => 그러나 변수 이름하고는 상관없다.
 * => 인스턴스를 생성할 때 반드시 여러 개의 생성자 중에서 호출될 생성자를 지정해야 한다.
 
 */
package step07;

import step07.Test03_4.Student;

public class Test03_5 {
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
      this.age = age;
      this.name = name;
    }
    /* 오버로딩(Overloading)
     * => 이렇게 파라미터 타입이 다르거나 개수가 다른, 생성자 또는 메서드를 여러 개 중복해서
     *      만드는 문법을 말한다.
     */
  }
  public static void main(String[] args) {
    System.out.println(new Student((int)20L).age);
    System.out.println(new Student("임꺽정",20).name);
    // new Student(true);// 논리값을 받아내는 생성자가 없으므로 컴파일 오류

  }
}
