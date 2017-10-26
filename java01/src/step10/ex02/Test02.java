/* 다형성 - 다형적 변수 2
 * => 왜? 수퍼 클래스의 인스턴스를 저장할 수 없는가?
 */
package step10.ex02;

public class Test02 {

  public static void main(String[] args) {
//    Member m = new Member(); //ok
//    Member m = new Student(); // ok Member의 변수 + student의 변수
    Member m = new FreeStudent(); //OK 멤버 + 학생 + 프리학생
    m.name = "홍길동";
    m.id = "홍";
    m.password = "1111";
    m.tel = "1111-1111";
    m.email = "홍@테스트.com";
    
//    Student s = new Student(); //ok member + student
    Student s = new FreeStudent(); //ok member + student + freestudent
//    Student s = new Member(); //Error .멤버 인스턴스만 사용가능함.
    s.name = "홍길동";
    s.id = "홍";
    s.password = "1111";
    s.tel = "1111-1111";
    s.email = "홍@테스트.com";
    s.schoolName = "비트대학교";
    s.grade = 4;
    
  }

}
