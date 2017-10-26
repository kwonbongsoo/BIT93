/* 데이터 프로세싱 스트림 클래스 = 직렬화와 transient 변경자
 * => 인스턴스의 변수 중에서 다른 인스턴스의 값을 바탕으로
 *      계산을 수행해서 나오는 값을 저장하는 변수의 경우
 *      굳이 저장할 필요가 없다.
 *      저장하는 것이 오히려 계산 오류를  만들수 있다.
 *      예) Student의 sum, aver 변수
 *      
 * => 그래서 이런 인스턴스 변수의 경우 데이터를 저장하기 위해 직렬화를 수행할 때
 *      직렬화 대상에서 제외시키는 것이 바람직 하다
 *
 * => 직렬화 대상에서 제외 시키기 위해 인스턴스 변수에 붙이는 옵션이 "transient"이다.
 */

package step16;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test05_3_out {
  public static void main(String[] args) throws IOException {

    
    // Student2 클래스는 모든 변수가 직렬화 대상이다..
    // => 즉 모든 변수의 값이 파일로 내보내진다.
    Student3 s = new Student3("홍길동", 100, 90, 80, false);
    FileOutputStream out0 = new FileOutputStream("temp/test05_3.data");
    ObjectOutputStream out = new ObjectOutputStream(out0);
   
    // 객체 출력
    // => 인스턴스의 값들을 바이트 배열로 만들어 출력한다. "직렬화(Serializeble)" 한다.
    // => 단, 해당 클래스에서 직렬화를 허락해야한다.
    out.writeObject(s); 
    
    out.close();
    out0.close();
  }
}

