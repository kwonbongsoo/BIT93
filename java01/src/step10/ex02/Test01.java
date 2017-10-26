/* 다형성 - 다형적 변수
 * => 어떤 레퍼런스 변수는 그 타입의 인스턴스 뿐만 아니라,
 *      그 타입의 서브클래스의 인스턴스까지 저장할 수 있다.
 */
package step10.ex02;

public class Test01 {

  public static void main(String[] args) {
    Member m = new Member();
    Member m2 = new Student();
    Student s1 = new FreeStudent();
    FreeStudent f1 = new FreeStudent();
    // "다형적 변수(Polymorphic variable)" - 다형성(polymorphism)
    // 한 개의 레퍼런스 변수가 다양한 객체의 주소를 담을 수 있다.
    // 물론 서브 클래스의 객체 주소만 담을 수 있다는 제약이 있다.
    Member m3 = new Teacher();
    Member m4 = new FreeStudent();
    Student s2 = new FreeStudent();
    

  }

}
