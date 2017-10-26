/* File 다루기 - File 클래스 사용법 9
 * => FIleFilter
 */

package step16;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Calendar;

public class Test01_9 {

  public static void main(String[] args) throws IOException{
    // 
   
    File f = new File("../"); 
    
   displayDirectory(f, 0);
  }
  public static void  displayDirectory(File dir, int level) {
    // =. lamda 문법
    // => 클로저? 메서드 한 개 짜리 익명 클래스를 만드는 단축 문법이다.
    //  => 반드시 메서드가 한 개인 인터페이스나 클래스만 가능하다.
    // => 보통 이런 메서드를 다른 언어에서는 클로저라 부른다.
 File[] files = dir.listFiles((File file) -> {
     if(file.isDirectory() || (file.isFile() && file.getName().endsWith(".class"))){
       return true;
     }
     return false;
});
    
    for (File file : files) {
        if (file.isDirectory()) displayDirectory(file, level+1);
        else System.out.printf("%s\n",  file.getPath());
    }
  }
}

