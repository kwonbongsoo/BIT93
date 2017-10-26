/* 프로그래램 아규먼트 연습
 * => 두 개의 값과 한 개의 연산자를 입력 받아 계산 결과를 출력하라!
 */
package step08;

public class Test01_2 {


  public static void main(String[] args) {

    if (args.length < 3) {
      System.out.println("[사용법]");
      System.out.println(">java -cp bin step08.Test01_2 10 * 200");
      System.out.println("연산자 : + - x /");
      return;
    }
    int a = Integer.parseInt(args[0]);
    String op = args[1];
    int b = Integer.parseInt(args[2]);
    int result;
    
    switch (op) {
    case "+": result = a+b;break;
    case "-": result = a-b;break;
    case "/": result = a/b;break;
    case "x": result = a*b;break;
    default :System.out.println("%s 연산자는 지원하지 않습니다");
    return;
    }
    printResult(a, b, op, result);

  }
  public static void printResult(int a, int b, String op, int result) {
    System.out.printf("%d %s %d = %d\n", a, op, b ,result);
  }
}
