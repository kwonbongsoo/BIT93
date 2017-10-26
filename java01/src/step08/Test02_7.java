/* 유틸리티 클래스 : Stirng III  - 문자열 비교
 * String 클래스는 immutable 객체이다
 * 한 번 값이 결정되면 변하지 않는다.
 * 값을 바꾸려하면 새로운 문자열 인스턴스가 자동 생성된다.
 */
package step08;

public class Test02_7 {


  public static void main(String[] args) {
    // 1) 문자열의 인스턴스 주소를 저장할 변수 선언
    String s1;
    
    // 2) 문자열 인스턴스를 생성
    // => Heap 영역에 char[] 배열이 만들어지고 그 배열안에 문자열이 보관된다.
    s1 = new String("Hello");
    String s2 = "Hello";
    
    String s3 = s1.replace('l', 'x');
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
  }
}
