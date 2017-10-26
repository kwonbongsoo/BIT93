/* 멀티 테스킹 : 스레드 만들고 실행하기
 * => 방법
 *      1) Thread를 상속 받아서 만들기
 *        만들기 : class MyThread extends Thread {}
 *        실행하기 : new MyThread().start()
 *        
 *      2) Runnable 규칙에 따라 만들기
 *        만들기 : class MyJob implements Runnable {}
 *        실행하기 : new Thread(new MyJob()).start()
 */
package step19;

public class Test02 {
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
    
    t1.start(); // t1 스레드를 독립적으로 실행시킨 후 즉시 리턴한다.
    t2.start(); // t2 스레드를 독립적으로 실행시킨 후 즉시 리턴한다.
    t3.start(); // t3 스레드를 독립적으로 실행시킨 후 즉시 리턴한다.
    
    
    for (int i = 0; i < 10000; i++) {
      System.out.printf("[main] %d\n",i);
    }
  }
}
