/* 멀티 테스킹 : 스레드의 우선 순위
 * => 자바는 스레드의 우선 순위를 10단계로 나눠 관리 한다.
 *      1 ~ 10 까지 지정한다
 * => "main" 스레드의 기본 우선 순위는 5이다.
 * => "main" 스레드에서 새 스레드를 만들면,
 *      그 스레드는 "main"의 자식 스레드가 된다.
 *      자식 스레드는 부모 스레드의 우선 순위와 동일한 값을 갖는다.
 * => 그런데,
 *      사실상 자바의 우선 순위는 실행에 별 영향을 끼치지 못한다.
 *      왜?
 *      스레드를 관리하는 것이 OS이기 때문이다.
 *      따라서 OS가 스레드를 관리 하는 방식(스케쥴링 방식)에 따라
 *      실행이 결정되기 때문이다.
 *  => 자바는 1 ~ 10 까지 우선순위의 단계가 있지만,
 *       그 자바를 실행하는 OS는 그 종류에 따라 단계가 다르다.
 *       예를 들면, Windows(7단계) Solaris(65535단계) 등
 *       이렇게 OS와 자바 사이에 단계의 일치하지 않기 때문에
 *       어차피 자바의 우선순위를 정밀하게 조정할 수 없다.
 * => 결론
 *      우선순위를 고려하여 프로그래밍을 하지 말라!
 */
package step19;

import step19.Test02.MyThread;

public class Test04 {
  static class MyThread extends Thread {
    public MyThread(String name) {
      this.setName(name);
    }
    public void run() {
      for (int i = 0; i < 10000;i++) {
        System.out.printf("[%s] %d\n", this.getName(), i);
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
    MyThread t1 = new MyThread("t1");
    MyThread t2 = new MyThread("t2");
    MyThread t3 = new MyThread("t3");
    Thread t4 = Thread.currentThread(); //main
    
    System.out.printf("t1 = %d\n", t1.getPriority());
    System.out.printf("t2 = %d\n", t2.getPriority());
    System.out.printf("t3 = %d\n", t3.getPriority());
    System.out.printf("t4(main) = %d\n", t4.getPriority());
    
    t2.start(); // t2 스레드를 독립적으로 실행시킨 후 즉시 리턴한다.
    t3.start(); // t3 스레드를 독립적으로 실행시킨 후 즉시 리턴한다.
    
    
    for (int i = 0; i < 10000; i++) {
      System.out.printf("[main] %d\n",i);
    }
  }
}
