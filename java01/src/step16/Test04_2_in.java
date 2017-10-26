/* 데이터 프로세싱 스트림 클래스 = BufferedInputStream 도입전 2
 * => 버퍼를 준비하여 일정량 만큼 읽는다.
 */

package step16;


import java.io.FileInputStream;
import java.io.IOException;

public class Test04_2_in {

  public static void main(String[] args) throws IOException{
    // 1) FileInputStream 객체 생성
    FileInputStream in = new FileInputStream("temp/test.pdf");
    
    byte[] buf = new byte[8196]; // 8KB = 1KB(1024byte) * 8
    // 용량을 크게 하면 더빠를수 있지만 만약 서버로 구동하게 되면
    // 1000명이 접속하면 한번에 메모리가 8기가가 사용되기 때문에 서버용으로 할때는
    // 잘게 쪼개는게 좋다.
    // 램은 유한한 자원이기 떄문에.
    int len = 0;
    int countPoint = 0;
    long start = System.currentTimeMillis();
    while ((len = in.read(buf)) != -1){
      System.out.print(".");
      if ((++countPoint % 50) == 0)
        System.out.println();
    }
    long end = System.currentTimeMillis();
    System.out.println();
    System.out.printf("걸린시간 : %d\n", end-start);
    in.close();
  }
}

