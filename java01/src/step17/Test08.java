/* 예외처리 :  throws 선언
 * => 예외를 발생시키는 코드를 작성 할 때 당장 예외 처리를 하고 싶지 않다면,
 *      메서드 선언부에 그 예외 정보를 적시하면 된다.
 *      그러면 그 메서드를 호출하는 쪽에서 처리할 것이다.
 * => 즉 해당 메서드에서 어떤 예외가 발생하는지 알리는 것이 목적이다.
 */
package step17;

public class Test08 {
 /* 다음의 경우 main() 메서드는 jvm이 호출하기 떄문에,
  * main()에서 예외가 발생했을 때 jvm이 처리한다.
  * 어떻게?
  * 그냥 그 예외에 대해 printStackTrace()를 실행한다.
  * jvm에게 예외처리를 위임하는 순간 main()의 호출은 종료 되기 때문에
  * 프로그램 실행도 종료된다는 사실을 명심해야 한다.
  */
  public static void main(String[] args) 
      throws Exception, IllegalArgumentException, NumberFormatException{
      if (args.length < 1) {
        throw new IllegalArgumentException("애플리케이션 아규먼트가 없습니다.");
      }
        int age = Integer.parseInt(args[0]);
        System.out.println(age);
        if (age < 1)
          throw new Exception("나이 실화냐?");
    }
  }

