/* 인스턴스 변수
 * => new 명령을 통해 생성하는 변수이다.
 * => 값을 개별적으로 구분해서 관리할 필요가 있을 때 사용한다.
 * => 클래스가 로딩될 때 생성되지 않는다.
 * => 인스턴스 주소를 통해 접근할 수 있다.
 * => 인스턴스 주소를 잃어버리면 해당 변수를 사용할 수 없다.
 * => 변수 선언에 static을 붙이지 않는다.
 */
package step07;

public class Test02_1 {
  static class Student {
    // 인스턴스 변수는 기본 값으로 0을 갖는다.
    // 주소 변수 : null이 들어가고,
    // 정수 변수 (Byte, short, int, long, char) : 0
    // 부동소수점 변수 (float, double) : 0.0
    // 논리 변수(boolean) : false
    // => 사실 null이나 false. 0.0 모두 메모리가 0으로 셋팅된다는 것을 의미한다.
    String name; //인스턴스 변수가 아니다.
    int age; // 만들라는 명령어 이다. 붕어빵틀 이라 생각하면됨
    boolean working; // 클래스 변수가 아니라 클래스를 로딩하고 클래스 변수를 만들라는 명령
    //new 명령어를 만나면 힙에 변수를 만들라는 명령

  }
  public static void main(String[] args) {
    Student s = new Student();
    Student s2 = new Student();
    
    s.name ="홍길동";
    s.age = 20;
    s.working = true;
    
    System.out.println(s.name);
    System.out.println(s.age);
    System.out.println(s.working);
    
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
