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
 * => 실행이 완료되면 Dead 상태가 되어 다시는 실행할 수 없다
 *      반복 실행 할 수 없다.
 *      
 * => wait()
 *      - 특정 객체를 사용하는 스레드에 대해 동작을 중지시킬 때 사용한다.
 * => notify(), notifyAll();
 *      - 
 */
package step19;


import step19.Test02.MyThread;

public class Test07 {
  static class Food {
    synchronized public void eat() throws InterruptedException {
      this.wait();
      System.out.println("맛있게 먹는다.");
    }
    synchronized public void allow() throws Exception {
      this.notify();
    }
  }
  static public class Dog extends Thread {
    Food food;
    
    public  Dog(Food food) {
      this.food = food;
    }
    public void run() {
      try {
        food.eat();
                      // 다른 스레드가 알려줄 때까지(notify())상태로 만든다?
      } catch (Exception e) {
        e.getStackTrace();
      }
      System.out.println("왈왈");
    }
  }
  
  static class Counter extends Thread {
    Food food;
    int length = 10;
    
    public Counter(Food food){
      this.food = food;
    }
    public void run() {
      while (true) {
        length--;
        System.out.printf("먹기 %d초 전\n",length);
        if (length == 0) {
          try {
            this.food.allow();
            return;
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        try {
          Thread.sleep(1000);
        }catch (Exception e){
          e.getStackTrace();
        }
      }
    }
  }
  
  public static void main(String[] args) {
  Food food = new Food();
  Dog dog = new Dog(food);
  dog.start();
  
  Counter counter = new Counter(food);
  counter.start();
  System.out.println("먹지말고 기다려");
  }
}
