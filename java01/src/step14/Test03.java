/* 제네릭(Generic) 문법: 사용후
 * => 
 */
package step14;

import java.util.Date;

public class Test03 {

  public static void main(String[] args) {
    //2)  타입을 지정해보자!
    //Bucket2<String> b= new Bucket2<String>();
    Bucket2<String> b= new Bucket2<>();
    
    // Java7 이후부터 new 명령 다음에 타입 지정을 생략할 수 있다.
    b.setValue(new String("Hello"));
    String str = b.getValue(); // 형변환이 필요 없다.
    System.out.println(str);
    // 클래스를 만들 때 다룰 값의 타입을 String으로 제한했기 때문에,
    // 다음과 같이 다른 타입의 값은 저장할 수 없다.
//    b.setValue(new Date()); //컴파일 오류
//    Date date = (Date)b.getValue(); // 컴파일 오류
    
    
  }

}
