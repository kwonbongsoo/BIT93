package step05;

import java.util.ArrayList;
import java.util.HashMap;

/* 메서드 : 여러ㅓ 개의 값을 리턴 하고 싶을때 */
public class Test04 {
  //3) map을 사용하면 값을 저장할 때 숫자가 아닌 문자열로 라벨을 붙일 수 있다.
  public static HashMap getStudent (int student) {
    HashMap map = new HashMap();
    map.put("이름", "홍길동");
    map.put("국어", 100);
    map.put("영어", 90);
    map.put("수학", 80);
    map.put("총점", 100 + 90 + 80);
    map.put("평균", (100 + 90 + 80) / 3f);
    return map;
  }
  public static void main(String[] args) {
    HashMap map = getStudent(100);
    
    System.out.println(map.get("이름"));
    System.out.println(map.get("국어"));
    System.out.println(map.get("영어"));
    System.out.println(map.get("수학"));
    System.out.println(map.get("총점"));
    System.out.println(map.get("평균"));
    
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
