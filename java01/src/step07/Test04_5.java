/* 클래스 변수와 클래스 메서드
 * => 클래스 메서드에서 클래스 변수를 사용할 때
 *      다른 로컬 변수와 헷갈리지 않는다면,
 *      클래스명을 생략해도 된다.
 */
package step07;

public class Test04_5 {
  static class Calculator {
   static int result;
   public Calculator(int value) {
     result = value;
   }
   public static void plus(int value) {
     result += value;
     //this.result = 10; // 클래스 메서드나 스태틱 블록에서는 this 변수가 없다. 컴파일 오류
     //this 가 생략 된게 아니라 클래스 이름이 생략된것이다.
   }
   public static void minus(int result) {
     Calculator.result -= result;
   }
  }
  public static void main(String[] args) {
    Calculator.plus(10);
    System.out.println(Calculator.result);
    
  }
}
