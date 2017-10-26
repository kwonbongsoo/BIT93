/* 클래스 변수와 인스턴스 메서드
 * => 인스턴스 메서드에서도 클래스
 */
package step07;

public class Test04_6 {
  static class Calculator {
   static int result;
   
   public void plus(int value) {
     Calculator.result += value;
     //this.result = 10; // 클래스 메서드나 스태틱 블록에서는 this 변수가 없다. 컴파일 오류
     //this 가 생략 된게 아니라 클래스 이름이 생략된것이다.
   }
   public void minus(int result) {
     Calculator.result -= result;
   }
  }
  public static void main(String[] args) {
    Calculator c = new Calculator();
    c.plus(10);
    System.out.println(Calculator.result);
    
  }
}
