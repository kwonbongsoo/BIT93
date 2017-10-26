package step02;

import java.net.Socket;

/* 자바의 원시 데이터 타입
 * 
 */
public class Test03 {

  public static void main(String[] args) {
    
    //2) 부동소수점 변수: 부동소수점 값을 저장할 때 사용하는 메모리
    float f; //4바이트 크기의 메모리
    double d; //8바이트 크기의 메모리
    
    f = 9.999999f;
    System.out.println(f);
    
    f = 999999.9f;
    System.out.println(f);
    
    f = 9.9999999f; // 유효자릿수 7자리를 넘기면? 값이 짤리거나 반올림한다.
    // 그래서 유효자릿수를 넘지 않는 값을 저장해야 올바르게 꺼낼수 있다.
    System.out.println(f);
    
    f = 3.14159234567f; // 값을 플룻으로 표현할 때 이미 값이 짤린다.
    System.out.println(f);
    
    
    f = Float.MAX_VALUE;
    System.out.println(f);
    
    d = 3.14159234567f;
    System.out.println(d);
    d = 3.14159234567;
    System.out.println(d);
    
    d = Double.MAX_VALUE;
    System.out.println(d);
  }

}
/* 변수 선언
 * => 문법
 *     - 데이터타입 : 저장할 값의 종류를 의미한다
 *     
 */ 