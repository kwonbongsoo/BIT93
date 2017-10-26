package step02;

import java.net.Socket;

/* 자바의 원시 데이터 타입
 * 
 */
public class Test02 {

  public static void main(String[] args) {

    byte b; //1바이트 크기의 메모리
    short s; //2바이트 크기의 메모리
    int i; //4바이트 크기의 메모리
    long l; // 8바이트 크기의 메모리
 
    b = -128; //Byte.MIN_VALUE;
    b = 127;
//    b = -129; // 1바이트 크기를 넘기 때문에 컴파일 오류!
//    b = 128; // 1바이트 크기를 넘기 때문에 컴파일오류
    
    s = -32768; //Short.MIN_VALUE;
    s = 32767;
//    s = -32769; // 2바이트 크기를 넘는 값이기 때문에 컴파일 오류!
//Test02.java    s = 32768; // 2바이트 크기를 넘는 값이기 때문에 컴파일 오류
    
    i = -2147483648; //Integer.MIN_VALUE;
    i = 2147483638;
//    i = 100L; //8바이트 값으로 넣겟다는 말이다.. i는 4바이트 변수로 오류가 뜬다
    l = Long.MIN_VALUE;
    l = Long.MAX_VALUE;
    l = Long.MIN_VALUE - 1; // 변수의 값을 컴파일러가 모르기 때문에 컴파일 단계에서는 오류가 발생하지 않는다.
    l = Long.MAX_VALUE + 1; // 하지만 실행할 때 오류가 발생한다.
                                        // 실행할 때 발생하는 오류를 Runtime Exception이라 부른다.

  }

}
/* 변수 선언
 * => 문법
 *     - 데이터타입 : 저장할 값의 종류를 의미한다
 *     
 */ 