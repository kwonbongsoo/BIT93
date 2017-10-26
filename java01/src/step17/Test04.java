/* 예외처리 :  catch 명령
 * => throw가 전달한 예외 객체를 받는 명령이다.
 * => 문법
 *      catch (예외 객체를 받을 변수)
 * => 예외 객체의 타입 별로 구분하여 받을 수 있다.
 *      - 변수의 타입에 따라 예외정보를 받을 catch문이 선택된다.
 */
package step17;

public class Test04 { 
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
          throw new Throwable("나이가 유효하지 않습니다");
    } catch (Throwable ex) { // catch 블록 안에 예외를 받는 코드를 넣는다.
      System.out.println(ex+ "catch문");
    }
  }

}
