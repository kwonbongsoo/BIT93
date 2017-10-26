/* 예외처리 :  throws 선언 3
 * => java.lang.RuntimeException 계열의 예외를 던질 때는
 *      예외를 처리하는 것이 선택사항이다.
 *      컴파일러가 문법적으로 강제로 요구하지 않는다.
 * => 즉,
 *      1) 예외를 처리하는 try ~ catch ~ 를 사용하지 않아도 되고,
 *      2) 메서드 선언 부에 throws를 쓰지 않아도 된다. (선택 사항이다)
 *      RuntimeException 계열 에러 일때만...
 * => 왜?
 *      스텔스 모드로 예외를 전달하기 위해 특별히 정한 규칙이다.
 */
package step17;

public class Test10 {
  // 코드에서 RuntimeException과 그 외 예외들이 함께 있을 때는 
  // throws 규칙에 따라 RuntimeException이 아닌 것은 적시해야 한다.
  // 물론, RuntimeException은 선택 사항이다.
  public static void main(String[] args) 
 throws Exception/* , IllegalArgumentException, NumberFormatException */{
      if (args.length < 1) {
        throw new IllegalArgumentException("애플리케이션 아규먼트가 없습니다.");
      }
        int age = Integer.parseInt(args[0]);
        System.out.println(age);
        if (age < 1)
          throw new Exception("나이 실화냐?");
    }
  }
