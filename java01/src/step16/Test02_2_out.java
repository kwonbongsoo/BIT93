/* File 다루기 - 바이트 스트림 클래스 - FileOutputStream
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

public class Test02_2_out {

  public static void main(String[] args) throws IOException{
    // 1) FileOutputStream 객체 생성
    FileOutputStream out = new FileOutputStream("test02_2.data");
    
    
    byte[] bytes = {0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77};
    out.write(bytes);
    out.close();
    System.out.println("파일 출력 완료!");
  }
}

