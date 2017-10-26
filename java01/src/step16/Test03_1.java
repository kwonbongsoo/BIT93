/* File 다루기 - 바이트 스트림 클래스 - ByteArrayOutputStream
 * => 바이트 배열 메모리를 출력하는 클래스이다.
 */

package step16;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Test03_1 {

  public static void main(String[] args) throws IOException{
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    
    out.write(0x66778899);
    out.write(0x77665544);
    out.write(0x12345678);
    
    // 출력 스트림을 다 사용했으면 파일을 닫아라
    // => 파일을 다루기 위해 준비했던 메모리를 해제시킨다.
    // => OS 파일 시스템과의 연결도 끊는다.
    // 항상 write()를 호출한 다음에 파일을 닫아라
    byte[] buf = out.toByteArray();
    
    
    /* 스트리밍 방식이 아니라 일반 방식으로 데이터를 읽는다.
    for (byte b : buf) {
      System.out.printf("%x", b);
    }
    */
    // 스트리밍 API를 사용해서 바이트 배열에서 값을 읽어보자!
    
    ByteArrayInputStream in = new ByteArrayInputStream(buf);
    int b = 0;
    while (true) {
      b = in.read();
      if (b == -1)
        break;
      System.out.printf("%x " ,b);
    }
    out.close();
  }
}

