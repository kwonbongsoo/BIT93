/* super 키워드의 사용
 * => 재정의하기 전의 메서드를 호출할 때 사용한다.
 * => super가 수퍼 클래스를 가리키는 것이라고 착각을 많이 한다.
 * => 정의!
 *      자신을 뺀 조상 클래스로 따라 올라가면서 메서드를 찾는다
 *      없으면, 컴파일 오류!
 * => super가 안붙고, this가 붙으면 현재 클래스부터 찾아 올라간다.
 *      
 */
package step10.ex04;

public class C extends B{
  int c;
  
  public void m2() { //B클래스의 m2() 재정의
    System.out.println("C.m2()");
  }
  public void m3() { // A클래스의 m3() 재정의
    System.out.println("C.m3()");
  }
  public void m5() { // 새로추가
    System.out.println("C.m5()");
  }
  
  public void test1() {
    m1(); //b
    m2(); //c
    m3(); //c
  }
  public void test2() {
    super.m1(); //b  재정의 하지 않았으면  그냥 상속 받은 메서드를 가리킨다. super는 무시된다.
                    // super는 무시된다.
    //수퍼 클래스를 찾았더니 B에 있다.
    super.m2(); //b C.m2를 가리키고 있지만 super를 만나 재정의된 B.m2()가 호출 된다.
    //수퍼 클래스부터 찾았더니 B에 있다
    super.m3(); //a //b에는 m3가 없다. 그러므로  존재하는 m3 A.m3()로 접근한다.
    // 수퍼 클래스부터 찾았더니 B에 없고 A에 있다.
    m4();         //b.m4 //현재 클래스 부터 찾았더니 c에 있다.
    super.m4(); // b.m4 <--- 재정의 하지 않았으면 super무시된다.
    // 수퍼 클래스부터 찾았더니 B에 있다
    m5();
    //super.m5(); // 재정의 하거나 상속받은 메서드가 아니기 때문에, 컴파일 오류!
                   // 조상중에 m5() 메서드가 없다.
    // 수퍼 클래스 부터 찾았더니 m5()가 어디에도 없다.
  }
}
