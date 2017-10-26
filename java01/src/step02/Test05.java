package step02;

import java.net.Socket;

/* 자바의 원시 데이터 타입
 * 
 */
public class Test05 {

  public static void main(String[] args) {
    //4) 논리 값 변수 : 논리 값을 저장할 때 사용하는 메모리
    boolean b; // 자바언어 명세서에 크기를 알려주지 않는다.
                       // 다만, JVM 명세서에서 int 메모리를 사용한다고 언급하고 있다.
                       // 그리고 배열로 만들 때는 byte 메모리를 사용한다고 설명하고 있다. 
    b = true;
    b = false;
//    b = 1; //컴파일 오류
//    b = 0;
//    b = null;
//    b = "true";
  }
}
