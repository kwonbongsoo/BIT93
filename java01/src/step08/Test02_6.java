/* 유틸리티 클래스 : mutable 객체는 문자열을 변경가능하다 imutable 객체는 문자열을 변경하지 못한다.
 * mutable의 대표적인객체가 StringBuffer이다. imutable은 String객체가 있다.
 * 
 */
package step08;

public class Test02_6 {


  public static void main(String[] args) {
    StringBuffer s1 = new StringBuffer("Hello");
    // StringBuffer 인스턴스는 상수 문자열로 인스턴스를 만들 수 없다.
    //반드시 new 명령을 사용해야한다.
    s1.replace(2, 4, "xx");
    System.out.println(s1);
  }
}
