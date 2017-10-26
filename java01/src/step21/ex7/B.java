/* 추상 클래스 2
 * => 추상 클래스는 일반 클래스와 같이 모든 멤버를 가질 수 있다.
 * => 일반 클래스는 추상메서드를 가질수 없다.
 * 
 */
package step21.ex7;

public abstract class B {
  public static void m1() {
    System.out.println("A.sm1()...");
  }
  public abstract void m2();
}
