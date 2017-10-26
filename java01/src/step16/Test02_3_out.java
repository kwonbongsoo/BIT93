/* File 다루기 - 바이트 스트림 클래스 - FileOutputStream
 * => 일부만 출력하기
 */

package step16;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class Test02_3_out {

  public static void main(String[] args) throws IOException{
    // 1) FileOutputStream 객체 생성
    FileOutputStream out = new FileOutputStream("test02_3.data");
    
    
    byte[] bytes = {0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77};
    out.write(bytes, 2, 3); // 바이트 배열에서 (Offset) 2번방 부터 3개 출력 
    out.close();
    System.out.println("파일 출력 완료!");
  }
}

