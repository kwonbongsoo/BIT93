/* 유틸리티 클래스 : Java.sql.Date 클래스
 * => java.util.Date 클래스의 서버 클래스이다.
 * => java.util.Date 클래스와 다른 점?
 *      => 기본 생성자가 없다.
 *           객체를 생성할 때 반드시 시간을 지정해야 한다.
 *      => toString()의 리턴 값은 yyyy-mm-dd 형식이다.
 */
package step08;

import java.sql.Date;

public class Test05_6{

  public static void main(String[] args) {
    long currTime = System.currentTimeMillis();
    System.out.println(currTime);
    Date today = new Date(currTime);
    System.out.println(today);
    
  }
}
