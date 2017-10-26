/* 캡슐화 (encapsulation): 패키지 멤버 클래스(일반 클래스)에 붙일 수 있는 modifier 종류
 * => 패키지 멤버 클래스?
 *      소스 파일 가장 밖에 선언한 클래스이다.
 *      일반적으로 작성하는 클래스이다.
 *      
 * => (default) : 아무것도 붙이지 않는 것.
 *        - 같은 패키지의 클래스 
 * => public 
 *       - 모든 패키지 접근가능
 */
package step11.ex01;

import step11.ex01.A;

public class Test07 {
  public static void main(String[] args) {
    //public 클래스는 다른 패키지에서 접근 할수 있다.
    step11.ex01.A  obj1 = new step11.ex01.A();
    //(default) 클래스는 같은 패키지에서만 접근할 수 있다.
    // =>Test07은 B 클래스와 같은 패키지에 있기 때문에 접근 가능!
    // => Test06은 B클래스와 다른 패키지에 있기 떄문에 접근 불가능!
    step11.ex01.B  obj2 = new step11.ex01.B();
    

    
  }
}
