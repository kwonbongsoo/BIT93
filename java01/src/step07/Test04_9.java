/* 클래스 메서드들 끼리 호출하기
 * =>  
 */
package step07;

public class Test04_9 {
  static class Calculator {
   
   public static void m1() {
     // 메서드 호출할 때 클래스명이 안 붙으면, 자동으로 붙인다.
     /*Calculator.*/m2();
   }
   public static void m2() {
     Calculator.m3();
   }
   public static void m3() {
     System.out.println("m3()....");
   }
  }
  public static void main(String[] args) {
    Calculator c = new Calculator();
    c.m1();
    
  }
}
