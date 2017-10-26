/* 멀티 테스킹 : 스레드 만들고 실행하기 2
 * => 스레드와 프로세스들은 CPU 사용권을 두고 경쟁전을 벌인다.
 *      OS는 이런 경쟁전을 나름의 규칙에 따라 관리한다.
 *      "CPU Scheduling"
 *      이렇게 OS가 CPU 사용권을 관리하는 경우 "선점형 멀티 태스킹 운영체제"라 부른다.
 *      MS Windows의 경우 Windows95 버전부터 섬점형 멀티 태스킹 운영체제가 되었다.
 * => 스케쥴링 기법
 *      1) 라운드 로빈 방식 (round - robin)
 *          - 각 프로세스에게 일정 시간을 분배하여 CPU를 사용하게 하는 방식이다.
 *          - MS Windows 운영체제에서 사용하는 방식
 *      2) 우선 순위 방식 (priority + aging)
 *          - 우선 순위가 높은 프로세스에게 더 많은 시간을 분배하는 방식이다.
 *          - 이 방식의 문제는 단 우선 순위가 낮은 프로세스의 경우
 *            우선 순위가 높은 프로세스에게 계속 실행에게 밀리는 문제가 있다.
 *          - 이를 극복하기 위해서 Aging기법을 이용하여
 *            실행이 한 번 밀릴 때 마다 우선 순위를 높여 줌으로써
 *            결국에는 실행할수 있게 만든다
 *          - 리눅스, 유닉스 운영체제에서 사용하는 방식
 *          
 * => 컨텍스트 스위칭(Context Switching)
 *      - 프로세스를 실행할 때 CPU 실행정보를 가져온 후 그 정보를 바탕으로 실행한다.
 *      - 이전에 실행한 프로세스의 정보는 PCB 영역에 저장한다.
 *      - 이렇게 프로세스를 실행할 때 마다 이전 프로세스의 정보를 가져오고,
 *        실행했던 프로세스의 정보를 저장하는 것을 "Context Switching"이라 부른다
 * => PCB(Process Control Block)
 *      - 프로세스를 실행하면 실행 정보를 관리하기 위해 각 프로세스 별로 PCB 영역이 준비된다.
 *      - PCB 영역에는 실행 상태, 실행할 때 참고하는 레지스트리의 값 등이 보관된다.
 */
package step19;

public class Test03 {
  static class MyThread extends Thread {
    // "main" 스레드와 병행하여(동시에) 실행할 코드는 반드시
    // run() 메서드를 오버라이딩 하여 그 메서드에 둔다.
    public void run() {
      System.out.println("MyThread....");
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
   // 1) Thread를 상속 받아 만든 스레드를 실행하기
   //    MyThread = Thread 기능 + 독립적으로 분리해서 실행할 작업
    MyThread t = new MyThread();
    t.start();
    
    
    // 2) Runnable 규칙에 따라 만든 클래스를 스레드로 실행하기
    // MyJob = 독립적으로 분리해서 실행할 작업
    // MyJob 클래스는 스레드 기능이 없다. 그래서 Thread 클래스의 도움을 받아서 실행한다.
    
    MyJob job = new MyJob();
    Thread t2 = new Thread(job);
    t2.start();
  }
}
