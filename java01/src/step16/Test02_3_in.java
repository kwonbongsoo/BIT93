/* File 다루기 - 바이트 스트림 클래스 - FileInputStream
 * => 바이트 배열을 읽은 후 저장할 위치를 지정하기
 */

package step16;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class Test02_3_in {

  public static void main(String[] args) throws IOException{
    // 1) FileInputStream 객체 생성
    FileInputStream in = new FileInputStream("test02_4.data");
    
    // read()
    // => 바이트 배열을 저장할 메모리를 준비한다.
    byte[] bytes = new byte[1024];
    // read(배열주소, offset, length)
    // => 배열주소: 데이터를 저장할 배열
    // => offset: 저장할 위치(index; 0 부터 ~)
    // => length: "희망"하는 읽을 바이트 수
    // => 리턴 값: 실제 읽은 바이트수
    int len = 0;
    len = in.read(bytes); // bytes[5]방 부터 2개의 정보를 읽어서 넣어라.
    for (int i = 0; i < 10; i++) {
      System.out.printf("%x ",bytes[i]);
    }
    
    // new라는 명령어는 heap 메모리를 생성하라는 말인데 배열을 만들면
    // 변수가 자동으로 0으로 초기화된다 boolean 타입은 false로 초기화 된다.
    in.close();
  }
}

