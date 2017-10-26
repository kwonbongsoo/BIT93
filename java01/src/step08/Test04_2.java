/* 유틸리티 클래스 : 랩퍼(Wrapper) 클래스 2 - equals() 메서드

 */
package step08;

public class Test04_2{

  public static void main(String[] args) {
    Integer i1 = new Integer(10);
    Integer i2 = new Integer(10);
    
    System.out.println(i1 == i2);
    System.out.println(i1.equals(i2));
    
    
    /* String 클래스와 랩퍼 클래스는 equals() 메서드를 재정의 하였다.
     * => 어떻게?
     *      주소가 아닌 값이 같은 지 비교하도록 재정의 하였다.
     */
    StringBuffer s1 = new StringBuffer("Hello");
    StringBuffer s2 = new StringBuffer("Hello");
    
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
    /* StringBuffer 클래스는 equals()를 재정의 하지 않았다.
     * 그래서 Object에 있는 equals()를 그대로 사용한다.
     * Object eqauls() 그대로 사용한다.
     * Object의 equals()는 주소를 비교한다 즉 연산자 == 와 기능이 같다.
     */
    
   
  }
}
