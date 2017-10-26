/* 주제: 이클립스에서 소스를 작성하고 컴파일하고 실행해보기!
=> 패키지에 소속된 클래스 실행하기
    java -cp bin 패키지명.패키지명.패키지명.클래스명
  java01> java -cp bin step01.Test01
=> 주의!
  클래스가 있는 위치를 지정할 때 패키지명까지 지정해서는 안된다.
  반드시 패키지가 있는 루트 폴더까지만 지정해야 한다.
  java01> java -cp bin/step01 Test01
 */
package step01;

public class Test02 {

  public static void main(String[] args) {
    // 기본 데이터 타입
    // 1) 정수 데이터 형
    System.out.println(2147483647); //정수 - 4바이트 크기 정수.
    System.out.println(100L); // 정수. 8바이트 크기.
    System.out.println('가'); // 문자 값. 2바이트 크기
    System.out.println('c');
    // 2) 부동 소수점 데이터형
    System.out.println(3.14f); //부동소수점. 4바이트 크기
    System.out.println(3.14); //부동소수점 값. 8바이트 크기
    // 3) 논리 데이터형
    System.out.println(true); //논리 값. 4바이트 크기
    // 4) 객체 데이터형
    System.out.println("문자열");
  }
}
