/* 캡슐화 (encapsulation): modifier 종류
 * => 캡슐화란?
 *      - 추상화를 무너뜨리지 않게 만드는 문법이다.
 *      - 추상화란? 어떤 목적에 맞게 동작하도록 
 *        클래스 안에 변수나 메서드를 정의한 것을 말한다.
 *      - 즉 클래스에 정의된 원래 목적에 맞게 동작할 수 있도록
 *        클래스 멤버(변수, 메서드, 이너 클래스)의 접근을 제한하는 것이다.
 *      - 만약 인스턴스 변수에 무효한 값을 들어가거나 
 *        사용하지 말아야할 메서드를 호출하게 되면,
 *        시스템이 목적한대로 동작하지 않을 수 있다.
 *        그래서 변수나 메서드, 이너 클래스의 접근을 제한하는 것이다.
 *      - 시스템이 목적한대로 동작하지 않는 문제를 막기위해서
 *        변수나 메서드, 이너 클래스의 접근을 제한하는 문법이다.
 *      - 무효한 값이 들어가면 클래스를 찾아서 정의(추상화)한 보람이 없어진다.
 *      - 즉 클래스의 역할을 깨지는 문제가 발생한다.
 * => private 
 *      - 클래스 멤버만이 접근 가능
 * => default
 *       - 같은 패키지 접근가능 + 클레스 멤버
 * => protected 
 *       - 같은 패키지 + 클래스 + 상속
 * => public 
 *       - 모두 접근가능
 */
package step11;

import step11.ex01.A;

public class Test03 extends A{
  public void test() {
    //this.v1 = 1; //private;
    //this.v2 = 2; //(default)
    this.v3 = 3; // protected. 상속받은 자식 클래스이기 때문에 가능
    this.v4 = 4; // public 
  }
  public static void main(String[] args) {
    A obj = new A();
    
    // obj.v1 = 1; // private
    //obj.v2 = 2; // (default)
    // obj.v3 = 3; // protected 남의것은 안된다. 상속 받아서 만든 변수에 대해서만 가능.
    obj.v4 = 4;
  }
}
