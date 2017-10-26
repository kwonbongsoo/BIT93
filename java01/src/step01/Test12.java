/* 주제: 이스케이프 문자
 */
package step01;

public class Test12 {
  public static void main(String[] args) {
    // => 이클립스에서 실행하면 온전히 동작을 확인 할수 없다.
    // => 명령창에서 실행하라
    System.out.println("ABC\b가각간"); //backspace(0x0008)
    System.out.println("ABC\t가각간"); //tab (0x0009)
    System.out.println("ABC\n가각간"); // new line 다음줄 (0x000a)
    System.out.println("ABC\f가각간"); // formfeed 현재 커서의 위치에서 줄을 바꾼다. (0x000c)
    System.out.println("-----------------------------------------------------");
    System.out.println("ABC\r가각간"); // carrage return 커서를 처음으로 보낸다 (0x000d)
    System.out.println("ABC\"가각간"); // double quote (0x0022)
    System.out.println("ABC'가각간"); //큰 따옴표 안에서는 탈출할 필요가 없다, 그냥 작은따옴표를 그대로 사용하면된다. (0x0027)
    System.out.println('\'');
    char c1 = '\'';
    System.out.println(c1);
    System.out.println("\\");//역슬레시를 그냥 적으면, 다음에 이스케이프 문자가 와야한다.
    //역슬레시를 그냥 적고 싶다면, 이스케이프 문자로 적어라!
    
    // 특히 파일 경로에서 디렉토리 경로를 표현할 때 주의해야한다.
    System.out.println("c:\\workspace\\java01\\src\\bin\\Test12\\.java");
  }
}

/* 이스케이프 문자
 * => 일반 문자가 아닌 특별한 명령어를 의미하는 문자
 * => 문법
 *      \문자
 *   줄바꿈 문자
 *   => windows: crlf(0x0d0a, 2바이트로 표현)
 *   => unix/Linux: LF
*/
