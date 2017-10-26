/* 클래스 변수와 인스턴스 메서드 II
 * => 클래스 메서드에서 인스턴스 변수를 사용할 수 없다!
 * => 이유?
 *      인스턴스 생성하지 않고 클래스 
 */
package step07;

public class Test04_7 {
  static class Calculator {
   int result;
   
   public static void plus(int value) {
     //인스턴스 변수는 인스턴스 주소가 있어야만 사용할 수 있다.
     // 클래스 메서드(= 스태틱 메서드)
     result += value;
   }
   public static void minus(int value) {
     result -= value;
   }
  }
  public static void main(String[] args) {
    Calculator c = new Calculator();
    c.plus(10);
    
  }
}
