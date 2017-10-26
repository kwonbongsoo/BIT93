/* 데이터 프로세싱 스트림 클래스 = BufferedInputStream 도입전 2
 * => 버퍼를 이용하여 출력 속도 향샹시키기
 *      1만 바이트 마다 출력하게 되면, 속도가 빨라 진다.
 */

package step16;


import java.io.FileOutputStream;
import java.io.IOException;

public class Test04_2_out {

  public static void main(String[] args) throws IOException{
    // 1) FileInputStream 객체 생성
    FileOutputStream out = new FileOutputStream("temp/test04_2.data");
    
    byte[] buf = new byte[8196];
    int len = 0;
    long start = System.currentTimeMillis();
    for (int i = 1; i < 4000000; i++) {
      buf[len++] = (byte)i;
      if (len == 8196) {
        out.write(buf);
        len = 0;
      }
      
      if ((i % 10000) == 0) System.out.print(".");
      if ((i % 500000) == 0) System.out.println();
    }
    if (len > 0) {
      out.write(buf, 0, len);
    }
    
    long end = System.currentTimeMillis();
    System.out.println();
    System.out.printf("걸린시간 : %d\n", end-start);
    out.close();
  }
}

