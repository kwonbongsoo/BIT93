package step02;

import java.net.Socket;


public class Test04 {
  public static void main(String[] args) {
    //3) 문자 변수 : 문자의 유니코드 값을 저장할 때 사용하는 메모리
    char c; // 2바이트 크기의 메모리
             // short: -32768 ~ 32767
             // char 0~ 65535
    
    short s;
    s = -32768;
    s = 32767;
  
    //char 메모리는 유니코드 값을 저장하는 용도이다.
    // 그래서 유니코드 0 ~ 65535까지 값을 저장할 수 있게 되어 있다.
    c = 0;
    c = 65535;
//    c = -1;  // 오류 
    
    c = 44032;
    
    // 일반적으로 문자의 유니코드 값을 저장할 때 작은 따옴표('') 를 사용한다.
    c = '가';
    int i = '가';
    System.out.println(c+": "+i);
    
    i = '\b';
    System.out.println(i);
    i = '\t';
    System.out.println(i);
    i = '\n';
    System.out.println(i);
    i = '\f';
    System.out.println(i);
    i = '\r';
    System.out.println(i);
    i = '\'';
    System.out.println(i);
    System.out.printf("%x",i);
  }
}