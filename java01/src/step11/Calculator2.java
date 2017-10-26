package step11;

public class Calculator2 {
  // 외부에서 직접 접근하지 못하게 제한한다.
  // 오직 이 클래스 멤버만이 접근할 수 있다.
  private int result;
  
  public void plus(int value) {
    result += value;
  }
  
  public void minus(int value) {
    result -= value;
  }
  
  public int getResult() {
    return this.result;
  }
}
