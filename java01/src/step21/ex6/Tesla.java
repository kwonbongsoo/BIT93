package step21.ex6;

// 이제부터 Tesla도 CarTester 자동차 검사소에서 테스트를 수행할 수 있도록
// Vehicle 규칙을 준수해야한다.
public class Tesla extends Motor implements Vehicle{
  int charge;
  
  public void doCharge() {
    charge = 100;
  }
  
  public void run() {
    System.out.println("조용히 달린다.");
  }
}
