/* 데이터 프로세싱 스트림 클래스 = ObjectOutputStream 도입 전
 * => 객체 출력하기!
 */

package step16;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Test06_1_out {
  public static void main(String[] args) throws IOException{
    
    FileOutputStream out = new FileOutputStream("temp/test06_1.data");
    
    out.write('A'); // 0x0041 ---> 41
    out.write('B'); // 0x0042 ---> 42
    out.write('C'); // 0x0043 ---> 43
    out.write('a'); // 0x0061 ---> 6
    out.write('b'); // 0x0062 ---> 62
    out.write('c'); // 0x0063 ---> 63
    out.write('가'); //0xac00 ---> 00
    out.write('각'); //0xac01 ---> 01
    out.write('간'); //0xac04 ---> 04
    
    out.close();
    
    FileWriter out2 = new FileWriter("temp/test06_1.char.data");
    
    // character stream 클래스는 유니코드를 OS 기본 문자집합의 코드 값으로 변환하여 출력한다.
    // 만약 파일의  문자 집합을 지정한다면, jvm은 그 문자집합의 코드 값으로 변환하여 출력할 것이다.
    // 방법?
    // > java -cp -Dfile.encoding=utf-8 step16.Test06_1_out
    
    out2.write('A'); // 0x0041 ---> 41
    out2.write('B'); // 0x0042 ---> 42
    out2.write('C'); // 0x0043 ---> 43
    out2.write('a'); // 0x0061 ---> 61
    out2.write('b'); // 0x0062 ---> 62
    out2.write('c'); // 0x0063 ---> 63
    out2.write('가'); //0xac00 ---> eab080
    out2.write('각'); //0xac01 ---> eab081
    out2.write('간'); //0xac04 ---> eab084
    
    out2.close();
  }
}

