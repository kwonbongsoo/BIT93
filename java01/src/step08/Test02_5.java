/* 유틸리티 클래스 : Stirng III  - 문자열 비교
 * => String 클래스
 */
package step08;

public class Test02_5 {


  public static void main(String[] args) {
    // 1) 문자열의 인스턴스 주소를 저장할 변수 선언
    String s1;
    
    // 2) 문자열 인스턴스를 생성
    // => Heap 영역에 char[] 배열이 만들어지고 그 배열안에 문자열이 보관된다.
    s1 = new String("Hello");
    String s2 = "Hello";
    System.out.println(s1.hashCode());
    System.out.println(s2.hashCode());
   if (s1.equals(s2)) 
     System.out.println("같네");
   else 
     System.out.println("틀리네");
  }
}
