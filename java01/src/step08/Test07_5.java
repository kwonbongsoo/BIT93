/* 컬렉션(Collection) 클래스 : 컬렉션 클래스 사용 - HashSet
 * => 저장하려는 객체에 대해 hashCode()ㅎ출
 */
package step08;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test07_5 {
  
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
    Set dateSet = new HashSet();
    
    dateSet.add(new Book("감동실화", "봉수출판사", 1000));
    dateSet.add(new Book("aaa", "봉수출판사", 100));
    dateSet.add(new Book("bbb", "봉수출판사", 200));
    dateSet.add(new Book("ccc", "봉수출판사", 300));
    dateSet.add(new Book("ddd", "봉수출판사", 400));
    dateSet.add(new Book("eee", "봉수출판사", 500));
    dateSet.add(new Book("fff", "봉수출판사", 600));
    dateSet.add(new Book("fff", "봉수출판사", 600));
    
    

    
    /* "김구" 문자열인 경우에 서로 다른 인스턴스임에도 불구하고 중복되지 않는다.
     * 왜?
     * => Set은 객체(의 주소)를 저장할 때 그 객체에 대해 hashCode() 메서드를 호출한 후,
     *      그 리턴 값으로 위치를 계산한다.
     * => 그런데 String 클래스는 같은 값을 갖는 경우 같은 hash value를 리턴하도록
     *      hashCode()를 오버라이딩 하였다.
     *      즉 위의 "김구" String 객체는 비록 인스턴스는 다르지만.
     *      값이 같기 때문에 hashCode()의 리턴 값도 같다. 
     *      위치 계산 값이 같으니까 같은 값으로 간주하여 중복 저장하지 않는다.
     */

    /* 결론!
     * HashSet 컬렉션에 값을 저장할 때,
     * 인스턴스의 주소가 영향을 끼치는 것이 아니라 
     *  hashCode()의 리턴 값이 영향을 끼친다
     * 
     */
    
    // Set 컬렉션에서 값을 꺼내려면 별도의 도움을 받아야 한다.
    
    // 값을 꺼내 주는 도구를 먼저 얻는다.
    
//    Object[] valueList = dateSet.toArray();
//    for (int i = 0; i < valueList.length; i++) {
//      System.out.println(valueList[i]);
//    }
    // 방법2) 값을 꺼내주는 도구를 이용하여 얻는다.
    Iterator iterator = dateSet.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next().toString());
    }
    
    
    
    
    /* "fff" 제목의 책이 중복저장 되었다. 이유는?
     * => hashCode()의 리턴 값이 다르기 때문이다.
     * => HashSet()은 값을 저장할 때 hashCode()의 리턴 값을 가지고 위치를 계산하는데,
     *      같은 값을 갖고 있더라도 hashCode()의 리턴 값이 다르기 때문에,
     *      다른 위치로 저장되어서 중복된 것이다.
     */
    
    
    System.out.println("-----------------------");
    System.out.println(new Book("ffff", "비트출판사", 600).hashCode());
    System.out.println(new Book("ffff", "비트출판사", 600).hashCode());
    
    /* 어? 아까 String인 경우 값이 같으면 hashCode()의 리턴 값도 같지 않았는가?
     * => 그것은 String 클래스에서 Object로 부터 상속 받은 hashCode()를
     *       오버라이딩(재정의) 했기 때문이다.
     *       
     * 그럼, book
     */
  }
}







