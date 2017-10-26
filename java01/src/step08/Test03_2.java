/* 유틸리티 클래스 : Object
 * => 자바의 최상위 클래스이다.
 * => 모든 자바 클래스는 Object의 서브 클래스 이다.
 * => 클래스를 만들 때 특별히 다른 클래스를 상속 받지 않는다면,
 *      자동으로 Object를 상속 받는다.
 * => 왜 자바의 모든 클래스는 Object의 sub 클래스로 만들까?
 *      자바 객체(인스턴스)를 다루기 쉽게 하기 위해서이다.
 * => 하는일?
 *       => 객체가 기본적으로 갖춰야할 변수와 메서드를 제공하는 역할
 *       => 주요 메서드
 *            toString() : 클래스이름과 인스턴스 ID를 문자열로 리턴한다.
 *                           => 프로그램 실행할 때 인스턴스의 내부 값을 간단히 살펴보기 쉽게
 *                                하기 위해 서브 클래스 들은 이 메서드를 재정의 하기도 한다.
 *            equals() : 인스턴스의 주소를 비교하여 true/false 값을 리턴한다.
 *                           => 인스턴스 내부의 값을 비교하도록 서브 클래스에서 재정의 하기도 한다.
 *            hashCode() : 인스턴스를 구별할 때 사용하는 4바이트 숫자로 된 ID 값.
 *                           => 서브 클래스에서 이 메서드를 재정의 하기도 한다.
 *            getClass() : 클래스 설계도를 리턴한다.
 *            finalize() : 쓰레기 수집기(garbage collector)가 가비지를 메모리에서 제거하기 전에 
 *                         호출하는 메서드이다.
 *            
 */
package step08;
//super 클래스를 지정하지 않으면 자동으로 Object가 수퍼 클래스가 된다
public class Test03_2 {
  
  static class Student1 {
    String name;
    int age;
    // toString()을 재정의 하지 않았기 때문에, Object의 toString()을 사용할 것이다.
  }
  static class Student2 {
    String name;
    int age;
    
    public String toString() {
      
      return String.format("이름:%s\n나이:%d\n", name, age);
    }
  }
  public static void main(String[] args) {
    
   Student1 s1 = new Student1();
   
   s1.name = "홍길동";
   s1.age = 30;
   
   Student2 s2 = new Student2();
   s2.name = "임꺽정";
   s2.age = 30;
   
   System.out.println(s1.toString()); //onject tosring
   System.out.println("---------------------------------------------------");
   System.out.println(s2.toString());//override 한 tostring
   
   
  }
}
