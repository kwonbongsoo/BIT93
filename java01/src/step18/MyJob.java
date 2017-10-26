package step18;

public class MyJob  extends Object implements Runnable{
  // Runnable 규칙에 따라 클래스를 작성한 후, run() 메서드를 만든다.
  // 그리고 run() 메서드 안에 "main" 스레드와 병행하여(동시에) 실행할 코드를 둔다
  public void run() {
    System.out.println("MyJob....");
  }
}
