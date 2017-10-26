/* 예외처리 :  사용자 정의 예외 던지기
 * => 자바에서 마땅한 예외 클래스가 없을 경우,
 *      개발자가 직접 예외 클래스를 만들어 던질 수 있다.
 * => 애플리케이션 예외이어야 하기 때문에
 *      java.lang.Exception을 상속 받아서 만든다.
 * => 예외 처리할 때 예외 클래스의 기능에 따라 예외 클래스를 선택하는 것이 아니라,
 *      보통 그 상황에 적합한 설명을 간단히 표현할 수 있는 이름을 가진 클래스를 선택한다. 
 */
package step17;

public class Test07 {
  // 사용자 정의 예외 클래스를 만드는 이유?
  // => 기능을 확장하기 위함이 아니다.
  // => 예외 상황이 발생했을 때 클래스 이름으로 즉시 그 예외 상황을 파악할 수 있도록 하기 위함이다.
  // => 그래서 예외 클래스의 상속 관계는 이름으로 예외를 분류하는 데 의미를 두고 있다.
  static class InvalidValueScopeException extends IllegalArgumentException {

    public InvalidValueScopeException() {
      super();
    }

    public InvalidValueScopeException(String message, Throwable cause) {
      super(message, cause);
    }

    public InvalidValueScopeException(String s) {
      super(s);
    }

    public InvalidValueScopeException(Throwable cause) {
      super(cause);
    }
  }
  public static void main(String[] args) {
    // 다음과 같이 예외 상황이 발생했을 때 예외 정보를 던질 수 있는 코드를 실행할 때
    // 그 예외를 전달 받을 코드를 작성해야 한다.
    // try {} catch () {} 문법을 사용하여 처리하라!
    
    try { // try블록 안에 예외를 던질 수 있는 코드를 넣고
      if (args.length < 1) {
        throw new IllegalArgumentException("애플리케이션 아규먼트가 없습니다.");
      }
        int age = Integer.parseInt(args[0]);
        System.out.println(age);
        if (age < 1)
          throw new InvalidValueScopeException("나이 실화냐?");
    }catch (Throwable e) {
      e.printStackTrace();
    }
  }

}
