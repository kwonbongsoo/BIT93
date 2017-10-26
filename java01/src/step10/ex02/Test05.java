/* 다형성 - 다형적 변수와 instanceof 연산자
 * => instanceof 연산자는 레퍼런스에 들어 있는 인스턴스가 어떤 클래스의 인스턴스인지 검사한다.
 */
package step10.ex02;

public class Test05 {

  public static void main(String[] args) {
 
   Member m = new FreeStudent();
   m.name = "홍길동";
   m.id = "hong";
   m.email = "asdsdf";
   m.password = "1111";
   m.tel = "11111";
   
   FreeStudent s = (FreeStudent)m;
   
   s.schoolName = "비트대학교";
   s.grade = 4;
   s.account = "111-11-111-1111";
   s.bank = "비트은행";
   s.working = true;
   
   System.out.println(s.name);
   System.out.println(s.id);
   System.out.println(s.password);
   System.out.println(s.tel);
   System.out.println(s.email);
   System.out.println(s.schoolName);
   System.out.println(s.grade);
   System.out.println(s.account);
   System.out.println(s.bank);
   System.out.println(s.working);
   
   System.out.println(s.hashCode());
   System.out.println(m.hashCode());
   
   System.out.println(new FreeStudent().hashCode());
   System.out.println(new FreeStudent().hashCode());
   
  }
}
