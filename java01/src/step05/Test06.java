package step05;

import java.util.ArrayList;

/* 메서드 : 여러ㅓ 개의 값을 리턴 하고 싶을때 */
public class Test06 {
   static class Student {
     String name;
     int kor;
     int eng;
     int math;
     int sum;
     float aver;
   }
  //4) 사용자 (개발자가) 정의한 클래스의 객체로 리턴할 수 있다.
  public static Student getStudent (int student) {
    Student s = new Student();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 90;
    s.math = 80;
    s.sum = 100 + 90 + 80;
    s.aver = (float)s.sum / 3;
    return s;
  }
  public static void main(String[] args) {
    Student s2 = getStudent(100);
    System.out.println(s2.name);
    System.out.println(s2.kor);
    System.out.println(s2.eng);
    System.out.println(s2.math);
    System.out.println(s2.sum);
    System.out.println(s2.aver);
  }
}
/* 메서드 안에 선언한 변수는 메서드 호출이 끝나면 제거된다.
 * 그런데 getScore() 메서드에서 만든 배열이 어떻게 메서드 호출이 끝났는데도 계속 유지되는가?
 * => 객체는 "힙(heap)이라 불리는 영역에서 유지 된다.
 * => 그래서 메서드 호출이 끝나더라도 객체는 사라지지 않는다.
 * 
 * 로컬 변수는 그럼 어디에 저장되기에 메서드 호출이 끝나기가 무섭게 사라집니까?
 * => 로컬변수는 "스택(stack)"이라 불리는 영역에 유지된다.
 * => 스택 영역에 있는 변수는 메서드 호출이 끝나는 순간 제거된다.
*/
