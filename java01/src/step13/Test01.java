/* nested class(=inner class)
 * => 클래스나 메서드 안에 클래스를 정의하는 문법
 * => 특정 클래스 안에서만 사용되는 클래스는 클래스 안에 정의한다.
 * => 특정 메서드 안에서만 사용되는 클래스는 메서드 안에 정의한다.
 * => 종류!
 *        1) static nested class
 *        2) non-static nested class (= inner class)
 *        3) local inner class
 *        4) anonymous nested class
 *      
 */
package step13;

public class Test01 {
  // static nested class
  static class A {}
  class B {} // non-static nested class
  public static void main(String[] args) {
    
    class C {}// local class
    Object obj = new Object() {}; // anonymous class
    
    // lamda로 nested 클래스 표현
    Runnable obj2 = () -> {};
    

  }

}
