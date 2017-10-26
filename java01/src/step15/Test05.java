/* 상수 값 다루기 : enum 문법 적용 후
 * => 이 상수 값을 DBMS에 저장할 경우,
 *      해당 컬럼이 원하는 값으로 저장해야 하기 때문이다.
 *      
 */
package step15;

public class Test05 {
  public static void main(String[] args) {
    Student3 s = new Student3();
    s.setName("홍길동");
    s.setAge(20);
    
    // 임의의 숫자를 넣을 수 없다.
    // 반드시 그 상수 타입의 값을 넣어야 한다.
//    s.setSchoolLevel(4);
    
    s.setSchoolLevel(SchoolLevel2.MASTER);
    System.out.println(s.getSchoolLevel().value());
     

  }
}
