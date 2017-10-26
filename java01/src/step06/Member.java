package step06;

/* Test02_3.java 에 있던 성적 처리 관련 메서드를 분리하여 두는 클래스 
 * 또한 이들 메서드 또한 모아 두었다
 * static을 빼야한다.
 */
class Member {
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
