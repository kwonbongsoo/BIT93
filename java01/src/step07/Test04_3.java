/* 인스턴스 변수와 this 변수
 */
package step07;

public class Test04_3 {
  static class Calculator {
   int result;
   public Calculator(int value) {
     Calculator.this.result = value;
   }
   public void plus(int value) {
     Calculator.this.result += value;
   }
   public void minus(int result) {
     Calculator.this.result -= result;
   }
  }
  public static void main(String[] args) {
    Calculator c1 = new Calculator(10);
    c1.plus(10);
    System.out.println(c1.result);
    
  }
}
