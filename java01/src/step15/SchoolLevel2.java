/* enum 문법 : 상수를 정의할 때 값을 지정 할수 있다.
 * => 값을 지정하지 않고 상수의 이름만 지정한다.
 * => 상수 타입의 변수를 선언할 수 있다.
 */
package step15;

public enum SchoolLevel2 {
  // 다음 각각의 상수는 SchoolLevel2의 객체이다.
  // 즉 HIGH_SCHOOL의 타입이 "SchoolLevel2"라는 뜻이다.
  // 이 설명을 좀 더 쉽게 이해하기 위해서 다음 상수들이 자바 코드로 표현해보자 
  
  // 위의 각 객체는 상수명과 인덱스 값을 갖고 있다.
  // 상수명과 인덱스 값 표현은 Test03을 보면된다.
  // 각 상수 객체에 대해 생성자를 호출한다면 맨 끝 상수에는 세미콜론을 붙여야 한다.
  HIGH_SCHOOL(1), /* 의미 SchoolLevel2 HIGH_SCHOOL = new SchoolLevel2(1); */
  BACHELOR(2), /* SchoolLevel2 BACHELOR = new SchoolLevel2(2); */
  MASTER(3), /* SchoolLevel2 MASTER = new SchoolLevel2(3); */
  DOCTOR(4); /* SchoolLevel2 DOCTOR = new SchoolLevel2(4); */
  
  
  //생성자를 통해 받은 값을 저장할 인스턴스 변수
  // 상수 객체이기 때문에 생성자로 부터 한 번 값을 받으면 바꿀 일이 없다.
  // 그래도 바꿀 일이 없다는 것을 명확히 하기 위해 보통 final 변경자를 붙인다.
  private final int value;
  
  // enum 객체에 값을 지정하고 싶으면
  // 기본 생성자 대신 그 값을 받는 생성자를 선언해야 한다.
  // 주의!
  // enum 생성자는 외부에서 호출할 수 없다.
  // 오직 내부에서만 사용되는 생성자 이기 때문에
  // public등 modifier(변경자)를 붙일 수 없다
  SchoolLevel2(int value) {
    this.value = value;
  }
  
  // 가능하면 인스턴스 변수에 직접 접근하는 것을 막아라!
  // 메서드를 통해 값을 꺼내도록 하라!
  public int value() {
    return this.value;
  }
}
