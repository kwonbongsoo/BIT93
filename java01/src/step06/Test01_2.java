/* 객체지향프로그래밍(Object- Oriented Programming; OOP)
 * => 코드를 역할에 따라 분류하여 프로그래밍 하는 방법
 * => 역할에 따라 묶은 코드를 인간이나 사물처럼 하나의 독립된 개체로 간주한다.
 * => 코드를 인간 사회의 흐름과 같이 표현하기 때문에 이해하고 관리하기 쉽다.
 * => 클래스라는 문법으로 표현한다.
 *     1) 사용자 정의 데이터 타입을 만들 때 사용한다.
 *     2) 관련된 메서드를 관리하기 쉽게 묶을 때 사용한다.
 */
package step06;


public class Test01_2 {
  static class Student {
    String name;
    int[] scores = new int[3];
    int total;
    float aver;
  }
  
  public static void compute(Student s) {
    // 인스턴스(의 주소)를 파라미터로 넘기면
    // 해당 인스턴스의 합계와 평균을 구해서 그 인스턴스의 변수에 저장한다.
    s.total = s.scores[0] + s.scores[1] + s.scores[2];
    s.aver = s.total / 3f;
  }
  
  public static void print(Student s) {
    //인스턴스를 파라미터로 넘기면,
    // 해당 인스턴스의 값을 한 줄로 출력한다.
    System.out.printf("%s, %d, %d, %d, %d, %f\n", s.name, s.scores[0], s.scores[1], s.scores[2], s.total, s.aver);
  }
  
  public static void init(Student s, String name, int kor, int eng, int math) {
    s.name = name;
    s.scores[0] = kor;
    s.scores[1] = eng;
    s.scores[2] = math;
    
  }
  public static void main(String[] args) {

    Student s1 = new Student(); 
    init(s1, "홍길동", 100, 100, 100);
    compute(s1);
    print(s1);
    
    Student s2 = new Student();
    init(s2, "임꺽정", 90, 90, 90);
    compute(s2);
    print(s2);
    
    Student s3 = new Student();
    init(s3, "유관순", 80, 80, 80);
    compute(s3);
    print(s3);
    
  }
    

}
