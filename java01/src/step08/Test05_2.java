/* 유틸리티 클래스 : Java.util.Date 클래스 2
 * => 년, 월, 일, 시, 분, 초 값 꺼내기
 */
package step08;

public class Test05_2{

  public static void main(String[] args) {
    // 인스턴스를 만들면 현재 시간을 보관하고 있는 객체가 생성된다.
    java.util.Date today = new java.util.Date();
    System.out.println(today.getYear()+1900); // 기준이 1900년이다
    System.out.println(today.getMonth()+1);//기준이 0~11까지이다.
    System.out.println(today.getDate()); 
    System.out.println(today.getDay()); //그 주를 기준으로 한다. 0일 1월 2화 3수 4목 5금 6토
    System.out.println(today.getHours()); // 일을 기준으로 한다 0~23
    System.out.println(today.getMinutes());
    System.out.println(today.getSeconds());
    System.out.println(today.getTime()); // 1970년 1월 1일 0시 0분 0초를 기준으로 경과된 밀리초단위
    System.out.println(today.getTimezoneOffset());
    
    /* deprecated Method
     * => 향후 제거될 메서드이니 사용하지 말라고 권고하는 메서드이다.
     * => 왜 제거하려하는 건가?
     *      좀 더 유지보수 하기 좋게 다른 클래스로 기능을 이전하였기 때문이다.
     */
    
  }
}
