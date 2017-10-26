/* 인스턴스 끼리 호출하기
 * => 
 */
package step07;

public class Test04_10 {
  static class Calculator {
    int value;
   
   public Calculator(int value) {
    this.value = value;//보통은 클래스명을 생략한다.
                            // 로컬 변수에 value라는 이름의 
  }
   public void m1() {
     // 메서드 호출할 때 클래스명.this.이 안 붙으면, 자동으로 붙인다.
     /*Calculator.this.*/m2();
   }
   public void m2() {
     Calculator.this.m3();
   }
   public void m3() {
     System.out.println(value);
     System.out.println(" this의 참조값: "+this);
   }
  }
  public static void main(String[] args) {

    Calculator c1 = new Calculator(100);
    Calculator c2 = new Calculator(200);
    Calculator c3 = new Calculator(300);
    c1.m1();
    System.out.println("객체의 참조값: "+c1);
    c2.m1();
    System.out.println("객체의 참조값: "+c2);
    c3.m1();
    System.out.println("객체의 참조값: "+c3);
  }
}
