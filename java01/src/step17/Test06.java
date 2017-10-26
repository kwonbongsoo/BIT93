/* 예외처리 :  catch 작성 순서
 * => 예외를 던지면 그 예외를 받을 catch 문을 찾는데,
 *      catch 문이 선언된 순서대로 찾는다.
 * => 그래서 작성할 때 주의해야 한다.
 *      여러 개의 catch 문이 있을 때,
 *      최하위 클래스를 파라미터로 갖는 catch 문 부터 작성하라.
 *      왜?
 *      다형성의 다형적 변수 규칙상,
 *      레퍼런스 변수는 하위 타입의 객체까지 저장할 수 있다.
 *      그래서 상위 타입의 변수가 먼저 있으면, 하위 타입의 변수를 선언한 catch문은 영원히 실행되지 않는다.
 *  => 이런 이유 때문에 자바 컴파일러는 아예 이런 순서를 허락하지 않는다.
 */
package step17;

public class Test06 { 
  public static void main(String[] args) {
    // 다음과 같이 예외 상황이 발생했을 때 예외 정보를 던질 수 있는 코드를 실행할 때
    // 그 예외를 전달 받을 코드를 작성해야 한다.
    // try {} catch () {} 문법을 사용하여 처리하라!
    
    try { // try블록 안에 예외를 던질 수 있는 코드를 넣고
      if (args.length < 1) {
        throw new Throwable("애플리케이션 아규먼트가 없습니다.");
      }
        int age = Integer.parseInt(args[0]);
        System.out.println(age);
        if (age < 1)
          throw new Throwable();
    }catch (NumberFormatException e) {
      System.out.println("애플리케이션의 아규먼트가 숫자가 아닙니다."); 
    }catch (Exception e) {
      System.out.println("나이 값이 유효하지 않습니다.");
    }catch (Throwable ex) { // catch 블록 안에 예외를 받는 코드를 넣는다.
      System.out.println(ex.getMessage());
    }
  }

}
