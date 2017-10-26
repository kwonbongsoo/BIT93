package step05;



/* 메서드 : 스택(Stack) 메모리 
 * => 메서드가 호출 되면 그 메서드의 로컬 변수가 스택 메모리에 준비된다.
 * => 메서드 호출이 끝나면 그 메서드가 사용한 스택 메모리가 제거된다. 
 */
public class Test07 {
  public static void m1(int a) {
    m2(++a);
    System.out.println("m1 a:"+ a);
    m2(++a);
    System.out.println("m1 a:"+ a);
  }
  public static void m2(int a) {
    m3(++a);
    System.out.println("m2 a:"+ a);
  }
  public static void m3(int a) {
    ++a;
    System.out.println("m3 a:"+ a);
  }
  public static void main(String[] args) {
    int a = 20;
    m1(20);
    System.out.println("main a : "+a);
  }
}
