package step02;

import java.net.Socket;

/* 자바의 원시 데이터 타입
 * 
 */
public class Test1 {

  public static void main(String[] args) {
    // 자바의 최소단위 메모리 => primitive data type (원시타입=기본타입)
    //1) 정수 변수: 정수  값을 저장할 때 사용하는 메모리
    byte b; //1바이트 크기의 메모리
    short s; //2바이트 크기의 메모리
    int i; //4바이트 크기의 메모리
    long l; // 8바이트 크기의 메모리
    
    //2) 부동소수점 변수: 부동소수점 값을 저장할 때 사용하는 메모리
    float f; //4바이트 크기의 메모리
    double d; //8바이트 크기의 메모리
    
    //3) 문자 변수 : 문자의 유니코드 값을 저장할 때 사용하는 메모리
    
    char c; // 2바이트 크기의 메모리
    
    //4) 논리 값 변수 : 논리 값을 저장할 때 사용하는 메모리
    boolean bool; // 자바언어 명세서에 크기를 알려주지 않는다.
                       // 다만, JVM 명세서에서 int 메모리를 사용한다고 언급하고 있다.
                       // 그리고 배열로 만들 때는 byte 메모리를 사용한다고 설명하고 있다. 
    //5) 위의 8개의 원시 타입을 제외한 나머지는 모두 레퍼런스이다.
    // 레퍼런스 변수 (보통 줄여서 레퍼런스라 부른다.)
    // 레퍼런스 변수? 메모리의 주소를 저장하는 변수이다.
    Object obj;
    String str;
    Socket socket;
    Thread thread;
    

  }

}
/* 변수 선언
 * => 문법
 *     - 데이터타입 : 저장할 값의 종류를 의미한다
 *     
 */ 