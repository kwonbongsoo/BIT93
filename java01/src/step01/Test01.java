/* 
 * => 패키지에 소속된 클래스 실행하기
 * Java -cp bin 패키지명. 패키지명. 패키지명. 클래스명
 * java01> java -cp bin step01.Test01
 * => 주의!
 *    클래스가 있는 위치를 지정할 때 패키지명까지 지정해서는 안된다.
 *    반드시 패키지가 있는 
 */
package step01;

public class Test01 {

  public static void main(String[] args) {
    System.out.println("hello world!");
  }
}
