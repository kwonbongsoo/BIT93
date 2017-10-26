/* File 다루기 - File 클래스 사용법 3 */

package step16;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Test01_3 {

  public static void main(String[] args) throws IOException{
    // 파일 경로가 '/'로 시작하면 절대 경로를 의미하고,
    // '/'로 시작하지 않으면 상대 경로를 의미한다.
    // => 상대방경로 일 때 기준은? 이클립스에서 실행하면 프로젝트 풀더가 기준이된다.
    File f = new File("../"); 
    
    // 지정된 폴더의 들어 있는 파일 및 하위 폴더 이름 목록을 리턴한다
    String[] files = f.list();
    
    for (String n : files) {
      System.out.println(n);
    }
  }
}
