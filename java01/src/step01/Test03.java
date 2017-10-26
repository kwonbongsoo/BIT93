/* 주제: 정수리터럴
 */
package step01;

public class Test03 {

  public static void main(String[] args) {
   //1) 그냥 숫자를 작성하는 것은 4바이트 크기의 정수 값을 의미한다.
    System.out.println(10);
    System.out.println(-10);
    System.out.println(2147483647); // 4바이트 정수 양의 최대 값
    System.out.println(-2147483648); // 4바이트 정수 음의 최소 값
    
    //2) 8바이트 정수 값을 표현할 때는 숫자 뒤에 'L' 또는 'l' 을 붙인다.
    System.out.println(10l); // 소문자 l과 숫자 1이 구분이 어렵기 때문에 주로 대문자 L을 사용한다
    System.out.println(-10l);
    System.out.println(9223372036854775807L);  //8바이트 양의 정수 최대 값
    System.out.println(-9223372036854775808L); //8바이트 음의 정수 최소 값
  }
}
/* 리터럴(literal)?
 * => 코드 값에서 
 */