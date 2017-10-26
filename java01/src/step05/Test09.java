package step05;



/* 메서드 : 힙(Stack) 메모리 
 * => 어떤 메서드 인지 상관없이 new 명령으로 만드는 메모리를 모두 힙 영역에 보관된다.
 * => 힙 영역에 보관된 메모리는 메서드 호출이 끝나더라도 유지된다.
 * => 주소를 잃어 버려 가비지가 되고, 가비지 컬렉터에 의해 지워질 떄 까지 유지된다.
 * => 또는 JVM이 종료되기 전까지 유지된다. 
 */
public class Test09 {
  static class Student {
    String name;
    int age;
    boolean working;
    int[] scores;
  }
  public static Student createStudent() {
    Student s = new Student();
    s.name = "홍길동";
    s.age = 20;
    s.working = false;
    s.scores = new int[] {100, 90, 90};
    return s;
  }
  
  public static void main(String[] args) {
    Student s = createStudent();
    
    System.out.printf("이름 : %s\n", s.name);
    System.out.printf("나이 : %d\n", s.age);
    System.out.printf("재직 : %b\n", s.working);
    System.out.printf("점수 : %d, %d, %d\n", s.scores[0], s.scores[1], s.scores[2]);
    
  }
}
