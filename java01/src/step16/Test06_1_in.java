/* 데이터 프로세싱 스트림 클래스 = ObjectInputStream 도입전 
 * => 파일에 저장된 객체 값을 순서대로 읽는다.
 */

package step16;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Test06_1_in {

  public static void main(String[] args) throws Exception{
    // 1) FileInputStream 객체 생성
    FileInputStream in = new FileInputStream("test06_1.txt");
    
    // 캐릭터 스트림 클래스는 문자 단위로 데이터를 읽고 쓴다.
    // 1) 읽을 때
    //     => 문자의 인코딩 방식에 따라 1 ~ 4바이트를 읽어서 
    //           자바에서 사용하는 2byte 유니코드 값으로 바꿔 리턴한다.
    //     => 왜? 바꾸는가? 자바 내부에서 문자를 다룰 때 유니코드 값을 사용하기 때문이다.
    //  2) 쓸 때
    //     => 문자의 인코딩 방식에 따라 2byte유니코드 값을
    //          1~ 4 바이트 값으로 변환하여 출력한다.
    //          보통 OS의 기본 문자집합으로 변환하여 출력한다.
    //      => 왜 변환하는가?
    //           문자 코드를 다룰 때 자바는 2바이트 유니코드를 사용하고,
    //           운영체제는 MS949(MS windows)나 UTF-8(UNIX)을 사용하기 때문이다.
    //            즉 JVM 환경과 OS 환경에서 문자ㅗ드를 다루는 방식이 다르기 떄문이다.
    int b = 0;
    while ((b= in.read()) != -1) {
      System.out.printf("%x ", b);
    }
    System.out.println();
    
    in.close();
    System.out.println("---------------------------------------------------");
    
 // 1) FileInputStream 객체 생성
    FileReader in2 = new FileReader("test06_1.txt");
    
    int b2 = 0;
    while ((b2= in2.read()) != -1) {
      System.out.printf("%x ", b2);
    }
    System.out.println();
    
    in.close();

  }
}

