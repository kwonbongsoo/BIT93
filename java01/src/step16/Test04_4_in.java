/* 데이터 프로세싱 스트림 클래스 = BufferedInputStream 도입후
 * => 버퍼를 준비하여 일정량 만큼 읽는다.
 */

package step16;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Test04_4_in {

  public static void main(String[] args) throws IOException{

    FileInputStream in0 = new FileInputStream("temp/test.pdf");
    BufferedInputStream in = new BufferedInputStream(in0);
    
    int b = 0;
    int count = 0;
    long start = System.currentTimeMillis();
    while ((b = in.read()) != -1){
      if ((++count % 10000) == 0) System.out.print(".");
      if ((count % 500000) == 0) System.out.println();
    }
    long end = System.currentTimeMillis();
    System.out.println();
    System.out.printf("걸린시간 : %d\n", end-start);
    in.close();
    in0.close();
  }
}

