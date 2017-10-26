package step05;

import java.util.ArrayList;

/* 메서드 : 여러ㅓ 개의 값을 리턴 하고 싶을때 */
public class Test05 {
  //1) 다른 종류의 값이라면 Collection 이나 Map 객체에 담아서 그 주소를 리턴하라!
  public static ArrayList getStudent (int student) {
    ArrayList arr = new ArrayList();
    arr.add("홍길동");
    arr.add(100);
    arr.add(90);
    arr.add(80);
    arr.add(100 + 90 + 80);
    arr.add((100 + 90 + 80) / 3f);
    return arr;
  }
  public static void main(String[] args) {
    ArrayList list = getStudent(100);
    //getStudent()의 호출이 끝나더라도, 이 메서드에서 만든 객체는 "힙"에 계속 유지되기 때문에,
    // 그 객체의 주소만 알고 있으면 언제든지 그 객체를 찾아가 값을 꺼낼 수 있다.
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
/* 메서드 안에 선언한 변수는 메서드 호출이 끝나면 제거된다.
 * 그런데 getScore() 메서드에서 만든 배열이 어떻게 메서드 호출이 끝났는데도 계속 유지되는가?
 * => 객체는 "힙(heap)이라 불리는 영역에서 유지 된다.
 * => 그래서 메서드 호출이 끝나더라도 객체는 사라지지 않는다.
 * 
 * 로컬 변수는 그럼 어디에 저장되기에 메서드 호출이 끝나기가 무섭게 사라집니까?
 * => 로컬변수는 "스택(stack)"이라 불리는 영역에 유지된다.
 * => 스택 영역에 있는 변수는 메서드 호출이 끝나는 순간 제거된다.
*/
