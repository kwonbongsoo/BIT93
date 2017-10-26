/* nested class : non-static nested class
 * => 다른 말로 "inner 클래스" 라고도 한다.
 * => 인스턴스 멤버이기 때문에 다른 인스턴스 멤버만이 사용 할수 있다.
 */
package step13;

public class Test03_1 {
  // instance member
  int a;
  public void m1() {}
  class A { // non-static nested class = inner class
    int a;
  }
   
   // 인스턴스 블록에서는 인스턴스 멤버를 사용할 수 있다.
    public void test() {
      A obj = new A();
      obj.a = 200;
      a = 20;
      m1();
      
    }
  public static void main(String[] args) {
    Test03_1 obj = new Test03_1();
    obj.test();
    
    // main()은 static 멤버이다. 인스턴스를 생성하지 않고 바로 호출하는 메서드이다.
    // 인스턴스 없이 호출하기 때문에, 그래서 인스턴스 멤버를 직접 사용할 수 없다.
    //test(); //test() 함수는 Test03_1의 내장된 인스턴스 메서드이기 때문에 test03_1 객체를 통해 접근할수 있다.
    
    // non-static nested class도 인스턴스 변수나 메서드처럼 인스턴스 멤버이다.
    // 그냥 인스턴스 메서드라고 간주를 하고 사용하면 된다.
    //Test03_1.A obj2 = new A(); // 컴파일 오류
    
    obj.a = 20;
    obj.m1();
    obj.test();
    A obj3 =obj.new A(); //ok
    /* 설명 
     * =>참조 변수를 선언할 때는 인스턴스 주소가 없어도 된다.
     * => 그러나 객체를 생성할 때는 인스턴스 주소를 앞에 두고 생성한다.
     */
    
  }
}
