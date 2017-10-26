/* 캡슐화(encapsulation): private 옵션
 * => 변수 선언이나 메서드 선언 앞에 붙여서
 *      그 변수나 메서드의 기본 성질을 변경한다고 해서 
 *      이런 키워드를 "변경자(modifier)"라고 부른다.
 * => 기본은 같은 패키지에 있는 클래스에 접근을 허용한다.
 */
package step11;

public class Test02 {
  // private 옵션:
  // 외부에서 직접 접근하지 못하게 제한한다.
  // 오직 이 클래스 멤버(클래스에 선언된 변수나 메서드)만드 접근할수 있다.

  public static void main(String[] args) {
    Calculator2 c = new Calculator2();
    
    c.plus(10);
    c.plus(7);
    c.minus(3);
   
    
   // result는 private 모드이기 때문에, 외부에서 접근하는 것이 제한된다.
    // 따라서 함부로 값을 바꿀수 없다.
   // c.result = 100; //컴파일 오류
    
    // 문제는 값을 꺼내주는 도구가 필요하다.
    
    System.out.println(c.getResult());

  }

}
