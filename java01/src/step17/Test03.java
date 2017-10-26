/* 예외처리 : 예외 발생 시 그 정보를 전달하고 전달 받는 방법
 * => 예외 정보를 호출자에게 전달하는 방법
 *      throw 예외정보를_담은_객체;
 *      => 예외 정보를 담은 객체란?
 *      java.lang.Throwable 타입의 객체이다.
 * => 예외 정보를 받는 방법
 *       try {
 *       
 *       } catch (예외를 받을 변수 선언) {
 *          예외를 처리하는 코드
 *       }
 * => 예외 처리 문법의 이점
 *    1) 예외가 발생하더라도 적당한 처리를 한 후
 *        시스템을 멈추지 않고 계속 실행 시킬수 있다.
 *    2) 메서드가 리턴하는 값의 타입과 상관없이 안전하고 확실하게 호출자에게 예외 정보를 전달할 수 있다.
 *    3) 예외를 처리하는 입장에서는 try 블록 안에는 예외  상황이 아닐 때에 작업 코드를 두고,
 *       catch 블록 안에는 예외를 처리하는 코드를 둠으로써
 *       정상 작업 코드와 예외처리 코드를 분리하는 효과가 있다.
 *       즉 코드의 가독성을 높여 준다. 
 */
package step17;

public class Test03 {

  public static float divide(float a, float b) throws Throwable{
    if (b == 0) {
      throw new Throwable("적당히 해라");
    }
    return a / b;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
      float result = divide(10, 3);
      
      
      if (result == -121255f) {
        System.out.println("0으로 나눌 수 없습니다.");
      } else {
        System.out.println(result);      
      }
      
      result = divide(121255, -1);
      if (result == -121255f) {
        System.out.println("0으로 나눌 수 없습니다.");
      } else {
        System.out.println(result);      
      }
      result = divide(10, 0);
      
    } catch (Throwable ex) {
      // 예외를 처리하는 코드는 catch 블록안에 둔다.
      System.out.println(ex.getMessage());
    }
  }

}
