/* 캡슐화 (encapsulation): 중첩 클래스(nested class)에 붙일 수 있는 modifier 종류
 * => 클래스 안에 선언된 클래스 "중첩 클래스(nested class)"라고 부른다.
 *      또는 "내부 클래스(inner class)"라고도 부른다.
 * => inner 클래스는 클래스 안에 선언되기 때문에,
 *      바깥 클래스의 멤버이다.
 *      따라서 클래스의 멤버인 변수나 메서드와 똑같이 modifier를 사용할 수 있다.
 */
package step11;

import step11.ex01.A;
public class Test09 { 
  static class Student {
    public static  final int HIGH_SCHOOL = 1;
    public static  final int BACHELOR = 2;
    public static  final int MASTER = 3;
    public static  final int DOCTOR = 4;
    
    // 필드 선언
    private String name;
    private int age;
    private int level;
    
    //세터 게터가 자바에서는 프로퍼티라고한다.
    public String getFullName() {
      return name;
    }
    public void setFullName(String fullName) {
      this.name = fullName;
    }
    public int getAge() {
      return age;
    }
    public void setAge(int age) {
      if (age > 5 && age < 100) {
        this.age = age;
      }else
        throw new RuntimeException("나이는 6에서 99살까지 가능합니다.");
      
    }
    public int getSchoolLevel() {
      return level;
    }
    public void setShoolLevel(int level) {
      if (level >= 1 && level <= 4) {
        this.level = level;
      }else
        throw new RuntimeException("학위 정보는 1에서 4까지 가능합니다.");
    }
    
    // 프로퍼티 선언
    // => 필드의 값을 넣거나 꺼내는 메서드
    // => setXxx()/getXxx() 이름으로 메서드를 정의한다.
    // => 그래서 setXxx() 메서드를 셋터(setter)라고 부른다.
    // => 그래서 getXxx() 메서드를 겟터(getter)라고 부른다.
    
  }
  public static void main(String[] args) {
    Student s = new Student();
    s.setFullName("홍길동");
    s.setAge(20);
    s.setShoolLevel(Student.DOCTOR);
  }
}
