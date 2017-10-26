/* 다형성 - 형변환의 희대의 사기꾼!
 * => 실제 그 타입의 인스턴스가 아님에도
 *      타입 케스팅(형변환)을 통해서 그 인스턴스라고 속이는 방법;
 * => 컴파일은 가능하지만 결국 실행할 때 오류가 발생한다.
 */
package step10.ex02;

public class Test06 {

  public static void main(String[] args) {
 
   Member m = new Member();
   m.name = "홍길동";
   m.id = "hong";
   m.email = "asdsdf";
   m.password = "1111";
   m.tel = "11111";
   
   FreeStudent s = (FreeStudent)m;
   
   
  }
}
