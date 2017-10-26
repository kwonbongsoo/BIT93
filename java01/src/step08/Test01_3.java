/* 프로그래램 아규먼트 연습
 * => 두 개의 값과 한 개의 연산자를 입력 받아 계산 결과를 출력하라!
 */
package step08;
/*
 * > java -cp bin step08.Test01.3 가위
 *    당신이 이겼습니다. ^-^;
 *    졌음
 *    비겻습니다
 *    => Math.random() 의 리턴값
 *    
 */
public class Test01_3 {


  public static void main(String[] args) {

    
    int a = (int)((Math.random() * 3)+1);
    String user = args[0];
    int b = 0;
    
    // 1 가위 
    // 2 바위
    // 3 보
   
    
    switch (user) {
    case "가위": b = 1;break;
    case "바위": b = 2;break;
    case "보": b= 3;break;
    default :System.out.println("꺼저");
    return;
    }
    printResult(a,b);

  }
  public static void printResult(int a, int b) {
    if(a == 1){
      if(b == 1) {
        System.out.println("비김");
      }else if (b == 2) {
        System.out.println("패배");
      } else {
        System.out.println("승리");
      }
    }else if (a == 2) {
      if (b == 1) {
        System.out.println("승리");
      }else if (b == 2) {
        System.out.println("비김");
      }else {
        System.out.println("패배");
      }
    }else {
      if (b == 1) {
        System.out.println("패배");
      }else if (b == 2) {
        System.out.println("승리");
      }else {
        System.out.println("패배");
      }
    }
  }
}
