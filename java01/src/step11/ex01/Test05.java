/* 캡슐화 (encapsulation): modifier 종류
 * => private 
 *      - 클래스 멤버만이 접근 가능
 * => default
 *       - 같은 패키지거나 클래스 맴버만 접근가능
 */
package step11.ex01;

import step11.ex01.A;

public class Test05 {
  public static void main(String[] args) {
    A obj = new A();
    
    // obj.v1 = 1; // private
    obj.v2 = 2; // (default) A와 같은 패키지에 있는 클래스 이다.
     obj.v3 = 3; // protected A와 같은 패키지에 있는 클래스이다.
    obj.v4 = 4;
  }
}
