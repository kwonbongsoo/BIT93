/* 유틸리티 클래스 :  java.util.Calendar 클래스
 * => 날짜 데이터에서 년, 월, 일, 시, 분, 초를 추출하거나 설정하고 싶다면,
 *      Calendar 클래스를 사용하라!
 *      기존의 java.util.Date 클래스나, java.sql.Date 클래스의 경우
 *      이런 정보를 추출하는 메서드가 deprecated 메서드로 권고받고 있다.
 *      즉 제거될 메서드이니 쓰지말라는 것이다!
 */
package step08;

import java.util.Calendar;

public class Test05_7{

  public static void main(String[] args) {
    //컨트롤 쉬프트 o 쓰면 쓰지않는 import를 지운다.
    //getInstance() 메서드를 호출하여 그 리턴 값을 사용하라!
    Calendar cal = Calendar.getInstance();
    
    //날짜 정보 추출
    //cal.get(꺼낼 값을 숫자로 지정한다)
    //년1 월2 일5 요일7 시10 분12 초13
    
    System.out.println(cal.get(1));
    System.out.println(cal.get(2)+1);
    System.out.println(cal.get(5));
    System.out.println(cal.get(7)); // 일1 ~ 토7
    System.out.println(cal.get(10)); //시간 ~ 0~11시
    System.out.println(cal.get(11)); //시간 0시 ~23시
    System.out.println(cal.get(12));
    System.out.println(cal.get(13));

    
  }
}
