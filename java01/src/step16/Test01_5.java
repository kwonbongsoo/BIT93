/* File 다루기 - File 클래스 사용법 3 */

package step16;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class Test01_5 {

  public static void main(String[] args) throws IOException{
    // 파일 경로가 '/'로 시작하면 절대 경로를 의미하고,
    // '/'로 시작하지 않으면 상대 경로를 의미한다.
    // => 상대방경로 일 때 기준은? 이클립스에서 실행하면 프로젝트 풀더가 기준이된다.
    File f = new File("../"); 
    
    // 지정된 폴더의 들어 있는 파일 및 하위 폴더 이름 목록을 리턴한다
   displayDirectory(f, 0);
  }
  public static void  displayDirectory(File dir, int level) {
 File[] files = dir.listFiles();
    
    for (File file : files) {
      for (int i = 0; i < level; i++) System.out.print("  ");
        
        System.out.printf("%s %s\n", 
            file.isDirectory() ? ">" : " ",
            file.getName()
            );
        if (file.isDirectory()) {
          displayDirectory(file, level+1);
        }
    }
  }
}
