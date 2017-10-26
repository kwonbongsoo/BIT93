/* 컬렉션(Collection) 클래스 : 컬렉션 클래스 사용 - HashSet
 * => 저장하려는 객체에 대해 hashCode()ㅎ출
 */
package step08;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test07_8 {
  
  static class Book {
    String title;
    String press;
    int page;
    
    public Book(String title, String press, int page) {
      this.title = title;
      this.press = press;
      this.page = page;
    }
    
    @Override
    public String toString() {
      // TODO Auto-generated method stub
      return String.format("%s, %s, %d", title, press, page);
    }
    
  }
  public static void main(String[] args) {
     HashMap map= new HashMap();
    
    map.put(new String("key1"),new Book("감동실화", "봉수출판사", 1000));
    map.put("key2",new Book("aaa", "봉수출판사", 100));
    map.put(new String("key3"),new Book("bbb", "봉수출판사", 200));
    map.put("key4",new Book("ccc", "봉수출판사", 300));
    map.put(1,new Book("ddd", "봉수출판사", 400));
    //오토박싱으로 integer 객체로 만들어서 object 로 들어간다. 자바컴파일이 알아서 처리한다.

    
    // 값을 꺼내는 방법
    // => 값을 저장할 때 사용한 key를 가지고 꺼낸다.
    // => 반드시 같은 인스턴스일 필요는 없다.
    //      저장할 때 사용한 key의 hashCode() 리턴 값과
    //      같은 hash value를 가진다면 값을 꺼내는 key로 사용할 수 있다.
    
    System.out.println(map.get("key1"));
    System.out.println(map.get(1));
    
  }
}







