
package step08;

public class Test02_1 {


  public static void main(String[] args) {
    // 1) 문자열의 인스턴스 주소를 저장할 변수 선언
    String s1;
    
    // 2) 문자열 인스턴스를 생성
    // => Heap 영역에 char[] 배열이 만들어지고 그 배열안에 문자열이 보관된다.
    s1 = new String("Hello");
    String s2 = s1;
    
    
    if(s1 == s2) {
      System.out.println("같네");
    }
  }
}
