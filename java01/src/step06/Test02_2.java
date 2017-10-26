/* class 문법의 용도:  관련된 메서드를 묶는 용도 II
 * => 코드를 기능 별로 묶어서 정의해두면 필요할 때 마다 다시 사용하기 편해진다.
 *      코드는 기능 별로 묶은 것을 "메서드(method)"라 부른다.
 */
package step06;


public class Test02_2 {
  
  static String name;
  static int[] scores = new int[3];
  static int total;
  static float aver;
  
  public static void compute() {
    // 인스턴스(의 주소)를 파라미터로 넘기면
    // 해당 인스턴스의 합계와 평균을 구해서 그 인스턴스의 변수에 저장한다.
    total = scores[0] + scores[1] + scores[2];
    aver = total / 3f;
  }
  
  // 성적 정보를 출력하는 기능을 수행하는 코드를 print() 블록 안에 묶어 두었다
  public static void print() {
    System.out.printf("%s, %d, %d, %d, %d, %f\n", name, scores[0], scores[1], scores[2], total, aver);
  }
  
  public static void init( String n, int k, int e, int m) {
    name = n;
    scores[0] = k;
    scores[1] = e;
    scores[2] = m;
    
  }
  

  public static void main(String[] args) {
 
    init("홍길동", 100, 100, 100);
    compute();
    print();
  }
}
