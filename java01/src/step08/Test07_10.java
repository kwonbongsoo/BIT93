/* 컬렉션(Collection) 클래스 : HashMap2
 */
package step08;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
// 사용자 정의 클래스를 map 컬렉션의 키로 사용할 때
public class Test07_10 {
  static class MyKey {
    String value;
    
    public MyKey(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      // TODO Auto-generated method stub
      return value;
    }
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((value == null) ? 0 : value.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      MyKey other = (MyKey) obj;
      if (value == null) {
        if (other.value != null)
          return false;
      } else if (!value.equals(other.value))
        return false;
      return true;
    }
    
  }
  
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
    
    map.put(new MyKey("key1"),new Book("감동실화", "봉수출판사", 1000));
    map.put("key2",new Book("aaa", "봉수출판사", 100));
    map.put(new MyKey("key3"),new Book("bbb", "봉수출판사", 200));
    map.put("key4",new Book("ccc", "봉수출판사", 300));
    map.put(1,new Book("ddd", "봉수출판사", 400));
    //오토박싱으로 integer 객체로 만들어서 object 로 들어간다. 자바컴파일이 알아서 처리한다.

    
    // 값을 꺼내는 방법
    // => 값을 저장할 때 사용한 key를 가지고 꺼낸다.
    // => 반드시 같은 인스턴스일 필요는 없다.
    //      저장할 때 사용한 key의 hashCode() 리턴 값과
    //      같은 hash value를 가진다면 값을 꺼내는 key로 사용할 수 있다.
    

    //Map 컬렉션에서 값 꺼내기
    // 방법1) 값 목록을 리턴 받아 꺼내기
    // => 값 목록을 리턴 받는다
    Collection valueList = map.values();
    
    // => 값이 들어 있는 컬렉션에서 값을 한 개씩 꺼내줄 도구를 얻는다.
    Iterator iterator = valueList.iterator();
    
    // => 그 도구를 사용하여 값을 꺼낸다.
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    
    System.out.println("------------------");
    
    // 방법2) key 목록을 리턴 받아 꺼내기
    // => key 목록을 리턴 받는다.
    Set keySet = map.keySet();
    
    // => key 목록에서 key를 한 개씩 꺼내줄 도구를 얻는다.
    Object[] keyArray = keySet.toArray();
    for (int i = 0; i < keyArray.length; i++) {
     System.out.println(map.get(keyArray[i]));
    }
    System.out.println("------------------------------------------------------");
    // => Set은 Collection의 서브 타입이다.
    //      Collection에 있는 값을 꺼낼 때 for문법을 사용할 수 있다.
    //      for (변수선언 :  배열또는 collection 객체)
    for (Object key : keyArray) {
      System.out.println(map.get(key));
    }
    
    System.out.println("------------------------------------------");
    
    // 방법3) key와 value를 한쌍으로 하는 목록을 리턴 받기
    // => key/value를 한 묶음으로 만든 목록을 리턴 받는다.
    Set entrySet = map.entrySet();
    for (Object object : entrySet) {
      Entry entry = (Entry)object;
      System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
    }
  }
}







