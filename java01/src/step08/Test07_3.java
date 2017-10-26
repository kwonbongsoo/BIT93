/* 컬렉션(Collection) 클래스 : var wordService = require('electron').remote.getGlobal('wordService')컬렉션 클래스 사용 - LinkedList
 * => 내부에서 목록을 다룰 때 bucket 역할을 수행하는
 *      Node 객채에 값을 담는다
 * => 그리고 그 Node 객체를 앞, 뒤로 연결한다.
 * => Node를 추가하고, 삽입하고, 제거하고, 조회하는 방법은
 *      linked list 알고리즘을 따른다.
 */
package step08;


import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Test07_3 {
  
  public static void main(String[] args) {
    HashSet dateSet = new HashSet();
    
    dateSet.add(Date.valueOf("2017-3-1"));
    dateSet.add(Date.valueOf("2017-5-3"));
    dateSet.add(Date.valueOf("2017-5-5"));
    dateSet.add(Date.valueOf("2017-5-9"));
    Date d1 = Date.valueOf("2017-6-6");
    dateSet.add(d1);
    dateSet.add(d1);
    
    // Set 컬렉션에서 값을 꺼내려면 별도의 도움을 받아야 한다.
    
    // 값을 꺼내 주는 도구를 먼저 얻는다.
    
//    Object[] valueList = dateSet.toArray();
//    for (int i = 0; i < valueList.length; i++) {
//      System.out.println(valueList[i]);
//    }
    // 방법2) 값을 꺼내주는 도구를 이용하여 얻는다.
    Iterator iterator = dateSet.iterator();
    System.out.println(iterator);
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}







