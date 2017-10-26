/* 예외처리 :  자원 자동 해제 try - catch 블록 (try-with-resorces 문장)
 * => try ~ catch ~ 문장에서 일반적으로 자원을 해제시키는 방법은
 *      finally 블록에서 수행한다.
 */
package step17;

import java.io.FileInputStream;
import java.io.IOException;

public class Test14_1{
  
  public static void main(String[] args) {
    FileInputStream in = null;
    // 자원을 자동 해제 시키는 try ~ catch 사용 전!
   try {
     in = new FileInputStream("step17.Test14.data");
     int b = 0;
     while ((b = in.read()) != -1) {
       System.out.printf("%x, ",b);
     }
     
   }catch (Exception e) {
     System.out.println(e.getMessage());
   }finally {
     try { in.close(); } catch (IOException e) { /* 무시 */}
   }
   System.out.println("안녕!");
  }
}

