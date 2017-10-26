/* 유틸리티 클래스 : 랩퍼(Wrapper) 클래스 2 - 오토 박싱(auto-boxing)
 * => 원시 데이터 타입과 랩퍼 클래스 간에 전환을 자동으로 처리하는 것!
 * => boxing    : 원시 데이터 타입의 값을 랩퍼 클래스의 인스턴스에 담는것
 *      unboxing : 랩퍼 객체(클래스의 인스턴스)에서 원시 데이터 타입에 값을 자동으로 추출하는것.
 */
package step08;

public class Test04_3{

  public static void main(String[] args) {
    int a = 10;
    Integer obj = new Integer(20);
    
    // 개발자가 명시적으로 랩퍼 객체에서 값을 꺼내기 
    int b = obj.intValue();
    int c = obj; // auto-unboxing : 랩퍼 객체에서 값을 자동으로 추출한다
    
    // 개발자가 명시적으로 랩퍼 객체를 만들어 값을 담기
    Integer obj2 = new Integer(a);
    Integer obj3 = a; // auto boxing 원시 타입의 값을 자동으로 랩퍼 객체를 만들어 담는다.
    Integer obj4 = 40;
    
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(obj2);
    System.out.println(obj3);
    System.out.println(obj4);
    
   
  }
}
