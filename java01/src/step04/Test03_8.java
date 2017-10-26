/* 문장: 반복문 do while */
package step04;

public class Test03_8 {

  public static void main(String[] args) {
    for (int i = 2; i < 10; i++) {
      System.out.print(i + ",");
    }
    System.out.println();
    //i = 10 // for 문 안에 선언된 변수는 블록을 벗어나면 사용할 수 없다.
    System.out.println("------------------------------------------");
    
    int i = 2;
    for (; i < 10; i++) {
      System.out.print(i + ",");
    }
    System.out.println();
    System.out.println("------------------------------------------");
    
    
    i = 2;
    for (; i < 10;) {
      System.out.print(i + ",");
      i++;
    }
    System.out.println();
    System.out.println("------------------------------------------");
    
    i = 2;
    for (; ;) {
      System.out.print(i + ",");
      i++;
      if ( i > 9)
        break;
    }
    System.out.println();
    System.out.println("------------------------------------------");
  }
  
  
}