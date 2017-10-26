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

public class Test02_1_out {

  public static void main(String[] args) throws IOException{
    // 1) FileOutputStream 객체 생성
    FileOutputStream out = new FileOutputStream("test02_1.data");
    
    // write(int) => 무조건 끝 1바이트만 출력
    out.write(0x66778899);
    out.write(0x77665544);
    out.write(0x12345678);
    
    // 출력 스트림을 다 사용했으면 파일을 닫아라
    // => 파일을 다루기 위해 준비했던 메모리를 해제시킨다.
    // => OS 파일 시스템과의 연결도 끊는다.
    // 항상 write()를 호출한 다음에 파일을 닫아라
    out.close();
  }
}

