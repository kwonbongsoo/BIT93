package step02;

import java.net.Socket;

/* 자바의 원시 데이터 타입
 * 
 */
public class Test01 {

  public static void main(String[] args) {

    byte b; //1바이트 크기의 메모리
    short s; //2바이트 크기의 메모리
    int i; //4바이트 크기의 메모리
    long l; // 8바이트 크기의 메모리
 
    b = -128;
    b = 127;
//    b = -129; // 1바이트 크기를 넘기 때문에 컴파일 오류!
//    b = 128; // 1바이트 크기를 넘기 때문에 컴파일오류
    
    s = -32768;
    s = 32767;
//    s = -32769; // 2바이트 크기를 넘는 값이기 때문에 컴파일 오류!
//Test02.java    s = 32768; // 2바이트 크기를 넘는 값이기 때문에 컴파일 오류

  }

}
/* 변수 선언
 * => 문법
 *     - 데이터타입 : 저장할 값의 종류를 의미한다
 *     
 */ 