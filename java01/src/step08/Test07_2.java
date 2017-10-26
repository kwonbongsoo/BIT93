/* 컬렉션(Collection) 클래스 : var wordService = require('electron').remote.getGlobal('wordService')컬렉션 클래스 사용 - LinkedList
 * => 내부에서 목록을 다룰 때 bucket 역할을 수행하는
 *      Node 객채에 값을 담는다
 * => 그리고 그 Node 객체를 앞, 뒤로 연결한다.
 * => Node를 추가하고, 삽입하고, 제거하고, 조회하는 방법은
 *      linked list 알고리즘을 따른다.
 */
package step08;


import java.sql.Date;
import java.util.LinkedList;

public class Test07_2 {
  
  public static void main(String[] args) {
    LinkedList dateList = new LinkedList();
    
    dateList.add(Date.valueOf("2017-3-1"));
    dateList.add(Date.valueOf("2017-5-3"));
    dateList.add(Date.valueOf("2017-5-5"));
    dateList.add(Date.valueOf("2017-5-9"));
    Date d1 = Date.valueOf("2017-6-6");
    dateList.add(d1);
    dateList.add(d1);
    
    System.out.println(dateList.size());
    
    dateList.add(3, Date.valueOf("2017-2-22"));
    
    Object removedObj = dateList.remove(3);
    
    Object oldObj = dateList.set(1, Date.valueOf("2017-5-4"));
    
    for (int i = 0; i < dateList.size(); i++) {
      System.out.println(dateList.get(i));
    }
    System.out.println("=>" + removedObj);
    System.out.println("=>" + oldObj);
  }
}







