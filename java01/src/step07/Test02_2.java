/* 인스턴스 변수
 * => 인스턴스 변수는 개별적으로 관리해야 할 값을 저장할 때 사용한다.
 */
package step07;

public class Test02_2 {
  static class Student {
    // 클래스 변수, 클래스가 로딩된 후 자동으로 Method Area 영역에 생성된다.
    static int guest = 0;
    static int member = 1;
    static int admin = 2;
    
    // 인스턴스 변수 new 명령을 실행할 때 생성된다.
    String name;
    int age; 
    boolean working;
    int level;
  }
  public static void main(String[] args) {
    Student s = new Student();
    Student s2 = new Student();
    
    s.name ="홍길동";
    s.age = 20;
    s.working = true;
    s.level = Student.guest;
    
    System.out.println(s.name);
    System.out.println(s.age);
    System.out.println(s.working);
    
    s.name ="임꺽정";
    s.age = 30;
    s.working = true;
    s.level = Student.admin;
    
    System.out.println(s2.name);
    System.out.println(s2.age);
    System.out.println(s2.working);
    
    int a;
    //주의!
    // => 로컬 변수는 0 값으로 자동초기화 되지 않는다.
    // => 클래스 변수와 인스턴스 변수만이 0으로 자동 초기화 된다.
    //System.out.println(a); //초기화시키지 않고 사용하려 하면 컴파일 오류!
    
    // 단지 이코드는 변수가 아니라 명령어이다.
    // 변수는 메모리내에 있는 변수가 진짜 변수이다.
     
  }
}
