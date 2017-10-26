/* nested class : static nested class 2  
 */
package step13;

public class Test02_2 {
//static nested class를 주로 사용하는 경우
 // => 계층 구조로 상수 값을 관리하고 싶을때
 //      특히 안드로이드 프로그래밍에서 ID 값을 관리하기 위해 이 문법을 사용한다.
 static class Member {
   String name;
   String tel;
   int schoolLevel;
   int userType;
   int working;
   int language;
 }

  public static void main(String[] args) {
   Member m = new Member();
   m.name = "홍길동";
   m.tel = "111-1111";
   m.schoolLevel = CSchool.BACHELOR;
   m.userType = CUserType.TEACHER;
   m.working = CWork.NOT_WORKING;
   m.language = CLanguage.JAVA;
   
  }
}
