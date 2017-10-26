/* 데이터 프로세싱 스트림 클래스 = BufferedInputStream 도입후
 * => 출력할 데이터를 먼저 버퍼에 출력한다.
 *      버퍼가 꽉차면 비로소 파일로 출력한다.
 *      
 */

package step16;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test04_4_out {
  
  public static void main(String[] args) throws IOException{
    // 1) FileInputStream 객체 생성
    FileOutputStream out0 = new FileOutputStream("temp/test04_4.data");
    BufferedOutputStream out = new BufferedOutputStream(out0);
    
    long start = System.currentTimeMillis();
    for (int i = 1; i < 4000000; i++) {
      out.write(i);
      if ((i % 10000) == 0) System.out.print(".");
      if ((i % 500000) == 0) System.out.println();
    }
    // 버퍼가 꽉 찼을 때 데이터를 출력한다.
    // 버퍼가 꽉 차지 않으면 출력하지 않는다.
    // => 이런 경우를ㄹ 방지하기 위해, 현재 버퍼에 있는 데이터를 강제로 출력시키는 방법이 필요하다.
    //      flush()를 사용하여 버퍼에 남아있는 데이터를 출력하라!
    out.flush();
    
    long end = System.currentTimeMillis();
    System.out.println();
    System.out.printf("걸린시간 : %d\n", end-start);
    out.close();
    out0.close();
  }
}

