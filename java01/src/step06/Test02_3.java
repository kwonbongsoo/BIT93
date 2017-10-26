/* class 문법의 용도:  관련된 메서드를 묶는 용도 III
 * => 서로 관련된 메서드를 관리하기 좋게 별도의 블록으로 묶는다.
 *      메서드를 기능에 따라 분류(classification)하여 별도의 블록으로
 *      분리시킨 것을 "클래스(class)"라 부른다.
 */
package step06;


public class Test02_3 {
  static class Member {
    //init() compute() 
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
  }
  public static void main(String[] args) {
 
    Member.init("홍길동", 100, 100, 100);
    Member.compute();
    Member.print();
  }
}
