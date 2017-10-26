/* File 다루기 - 바이트 스트림 클래스 - FileInputStream
 * => 바이트 스트림(byte stream, binary stream)?
 *      중간에 변경없이 바이트 단위 그대로 읽고 쓰는 클래스들.
 * => 상속 계층 구조
 *      InputStream
 *       1) Data Sink Stream 클래스 (데이터를 직접 읽고/쓰는 클래스)
 *          -> FileInputStream
 *          -> ByteArrayInputStream
 *          -> PipedInputStream
 *       2) Data Processing Stream 클래스 (데이터를 직접 읽고/쓰는 클래스)
 *          -> BufferedInputStream
 *          -> DataInputStream
 *          -> ObjectInputStream
 *       
 *      OutputStream
 *        1) Data Sink Stream 클래스 (데이터를 직접 읽고 쓰는 클래스)
     *        -> FileOutputStream
     *        -> ByteArrayOutputStream
     *        -> PipedOutputStream
 *        2) Data Processing Stream 클래스 (데이터를 직접 읽고/쓰는 클래스)
 *            -> BufferedOutputStream
 *            -> DataOutputStream
 *            -> ObjectOutputStream
 *            -> PrintStream
 */

package step16;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class Test02_2_in {

  public static void main(String[] args) throws IOException{
    // 1) FileInputStream 객체 생성
    FileInputStream in = new FileInputStream("test02_2.data");
    
    // read()
    // => 바이트 배열을 저장할 메모리를 준비한다.
    byte[] bytes = new byte[1024];
    int len = 0;
    len = in.read(bytes); // 바이트 배열의 값을 저장할 수 있는 메모리 주소를 준다.
                               // 리턴 값은 파일에서 실제로 읽은 바이트 개수이다.
    
    for (int i = 0; i < len; i++) {
      System.out.printf("%x ",bytes[i]);
    }
    in.close();
  }
}

