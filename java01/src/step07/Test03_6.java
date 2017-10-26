/* 초기화 블록 : 생성자 4
 * => 생성자가 한 개라도 있으면 기본 생성자를 자동으로 만들 지 않는다.
 
 */
package step07;

import step07.Test03_4.Student;

public class Test03_6 {
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
    Student(int age) {
      System.out.println("파라미터 age 생성자 호출");
    }
    Student(String name, int age) {
      System.out.println("이름 나이 받는 파라미터 생성자 호출");
      this.age = age;
      this.name = name;
    }

  }
  public static void main(String[] args) {
    System.out.println(new Student((int)20L).age);
    System.out.println(new Student("임꺽정",20).name);
    // new Student(true);// 논리값을 받아내는 생성자가 없으므로 컴파일 오류
    //new Student();// 기본생성자가 없기 떄문에 컴파일 오류

  }
}
