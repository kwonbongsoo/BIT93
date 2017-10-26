/* 멀티 테스킹 : 스레드의 라이프 사이클
 * => 생명 주기
 *                       start()                                    sleep()
 * new Thread() ---------------> Runnable 상태 -------------------->Not Runnable 상태
 *                                                  |        <--------------------
 *                                                  |        timeout, notify()
 *                                                  |
 *                                                     실행 완료
 *                                                 Dead
 *                                       
 * => Runnable 상태
 *      - CPU 쟁탈전에 놓인 상태
 *      - CPU를 받을 수 있는 상태
 *      - Runnable 상태에 있는 스레드 중 CPU를 사용하여 실행한다.
 * => Not Runnable 상태
 *      - CPU 쟁탈전에서 제외된 상태
 *      - CPU를 받을 수 없는 상태
 * => 실행이 완료되면 Dead 상태가 되어 다시는 실행할 수 
 */
package step19;

import step19.Test02.MyThread;
import step19.Test05_2.Account.ATM;

public class Test05_2 {
  static class Account {
    long balance;
    public Account(long balance) {
      this.balance = balance;
    }

    // Critical Section에 여러 스레드가 동시에 진입하지 못하게 막는 방법
    // => 그 메서드나 블록 옆에 synchronized 를 붙인다.
    public synchronized long  withdraw(long money) {
      long temp = this.balance;
      
      // 약간의 시간 지연을 발생시킨다.
      // 왜? 일부러 다른 스레드에게 cpu사용권을 뺏기기 위함
      double x = 3.141592;
      int delayCount = (int)(Math.random() * 10);
      for (int i = 0; i < delayCount; i++)
        x /= 345.2345;
      
      temp -= money;
      
      if (temp >= 0) {
        this.balance = temp;
        return money;
      }
      return 0;
      
    }
    static class  ATM extends Thread {
      Account account;
      
      public ATM(String name, Account account) {
        super(name);
        this.account = account;
      }
      
      public void run() {
        long sum = 0;
        for (int i = 0; i < 10000; i++) {
          long money = this.account.withdraw(100);
          if (money == 0)
            break;
          sum += money;
        }
        System.out.printf("%s= %d\n", this.getName(), sum);
      }
    }
  }
  
  static class MyJob implements Runnable {
    // Runnable 규칙에 따라 클래스를 작성한 후, run() 메서드를 만든다.
    // 그리고 run() 메서드 안에 "main" 스레드와 병행하여(동시에) 실행할 코드를 둔다
    public void run() {
      System.out.println("MyJob....");
    }
  }
  public static void main(String[] args) {
    Account account = new Account(1_000_000);
    ATM t1 = new ATM("강남", account);
    ATM t2 = new ATM("강북", account);
    ATM t3 = new ATM("강원", account);
    ATM t4 = new ATM("제주도", account);
    
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
