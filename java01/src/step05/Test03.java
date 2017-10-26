package step05;
/* 메서드 : 여러ㅓ 개의 값을 리턴 하고 싶을때 */
public class Test03 {
  //1) 같은 종류의 값이라면 배열에 담아서 배열 주소를 리턴하라!
  public static int[] getScore(int student) {
    // 학생의 성적 정보를 찾아서 리턴한다고 가정하자!
    int[] scores = {100, 90, 100};
    
    return scores;
  }
  public static void main(String[] args) {
    int[] arr = getScore(100); //getScore() 메서드에서 만든 배열 객체의 주소를 받는다.
    for (int value : arr) {
      System.out.println(value);
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
