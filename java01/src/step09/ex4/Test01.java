/* 상속 :  생성자 호출 2
 * => 서브 클래스 생성자 안에 수퍼클래스의 기본 생성자를 호출하는 
 *      코드를 두지 않으면, 컴파일러가 자동으로 수퍼 클래스의 기본 생성자를 호출하는 코드를 둔다.
 * => 증명!
 *      수퍼 클래스의 기본 생성자를 없애고 파라미터가 있는 생성자를 둔다.
 * => 수퍼클래스의 기본 생성자가 없으면
 */
package step09.ex4;

public class Test01 {

  public static void main(String[] args) {

    System.out.println(new C().b);

  }

}
