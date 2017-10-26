/* class 문법의 용도:  관련된 메서드를 묶는 용도 III
 * => 값을 개별적으로 관리하고 싶다면, 클래스에 선언된 변수 앞에 static 을 붙이지 마라!
 * => static이 붙지 않은 변수를 "인스턴스 변수"라 부른다.
 *      이 변수는 new 라는 명령에 의해 생성된다.
 * => static이 붙은 변수는 클래스를 사용하는 순간 자동으로 생성되고,
 *      static이 붙지 않은 변수는 new 명령을 사용하여 명시적으로 생성해야한다
 */
package step06;


public class Test02_6 {
  
  public static void main(String[] args) {
    Member2 m1 = new Member2();
    Member2 m2 = new Member2();
    Member2 m3 = new Member2();
    
    m1.init(m1, "홍길동", 100, 100, 100);
    m2.init(m2, "임꺽정", 90, 90, 90);
    m3.init(m3, "유관순", 80, 80, 80);
    
    Member2.compute(m1);
    Member2.compute(m2);
    Member2.compute(m3);
    
    Member2.print(m1);
    Member2.print(m2);
    Member2.print(m3);
    
  }
}
