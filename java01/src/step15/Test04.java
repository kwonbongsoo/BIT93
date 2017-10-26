/* 상수 값 다루기 : enum 문법 적용 후
 * => 이 상수 값을 DBMS에 저장할 경우,
 *      해당 컬럼이 원하는 값으로 저장해야 하기 때문이다.
 *      
 */
package step15;

public class Test04 {
  public static void main(String[] args) {
   
   
   SchoolLevel2[] values = SchoolLevel2.values();
   for (SchoolLevel2 sl : values) {
     System.out.printf("name() = %s\n",sl.name());
     System.out.printf("toString() = %s\n",sl.toString());
     System.out.printf("ordinal() = %s\n",sl.ordinal());
     // SchoolLevel2에 추가한 value() 함수를 호출하여
     // 그 상수 객체에 보관된 고유의 값을 꺼낸다.
     System.out.printf("value = %s\n",sl.value());
     System.out.println("----------------------------------");
     
     System.out.println(SchoolLevel2.BACHELOR);
     
   }
  }
}
