/* 데이터 프로세싱 스트림 클래스 = BufferedInputStream
 * => data processing stream 클래스?
 *      - 입출력 중간에 개입하여 데이터를 가공하는 역할을 수행한다.
 *      - 데이터를 직접 파일이나 메모리, 다른 애플리케이션으로 입출력 할 수 없다.
 * => DataInputStream / DataOutputStream
 *      - byte, short, int, long, float, double, boolean, char, String 타입의 데이터를
 *        바이트 배열로 가공하여 입출력을 수행한다.
 *      BufferedInputStream / BufferedOutputStream
 *        - 데이터를 읽고 쓸 때 중간에 버퍼(캐시: cache)를 이용한다.
 *        - 그래서 실제 파일로 입출력하는 횟수를 줄임으로써 읽고 쓰기 속도를 높이는 방법
 *      ObjectInputStrea / ObjectOutputStream
 *        - 객체를 바이트 배열로 만들어 출력하고, 바이트 배열을 다시 객체로 복원한다.
 *        
 * => BufferedInputStream?
 *        - 이객체는 내부에 데이터를 임시 저장할 바이트 배열을 내장하고 있다.
 *        - 데이터를 읽어 들일 때 최대한 바이트 배열 크기 만큼 한번에 읽어 들인다.
 *        - 그리고 그 버퍼에서 조금씩 퍼 쓰다가, 버퍼가 바닥나면 다시 그 버퍼만큼 읽어 들인다.
 *        - 이렇게 함으로써 읽어 들이는 횟수를 줄이게 되어 읽기속도가 향상된다.
 */

package step16;


import java.io.FileOutputStream;
import java.io.IOException;

public class Test04_1_out {

  public static void main(String[] args) throws IOException{
    // 1) FileInputStream 객체 생성
    FileOutputStream out = new FileOutputStream("temp/test04_1.data");
    
    long start = System.currentTimeMillis();
    for (int i = 1; i < 4000000; i++) {
      out.write(i);
      if ((i % 10000) == 0) System.out.print(".");
      if ((i % 500000) == 0) System.out.println();
    }
    
    long end = System.currentTimeMillis();
    System.out.println();
    System.out.printf("걸린시간 : %d\n", end-start);
    out.close();
  }
}

