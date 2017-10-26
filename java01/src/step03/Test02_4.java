/* 증가 / 감소 연산자 - 전위 연산자
 * 
 */
package step03;

public class Test02_4 {
  public static void main(String[] args) {
    
    int i = 4;
    int r = ++i + ++i * ++i;
    //        5   + (6 * 7)
    
    System.out.printf("i = %d , r = %d\n", i, r);
    
    i = 4;
    r = i++ + i++ *  i++;
    //   4 + (5 * 6)
    
    System.out.printf("i = %d , r = %d\n", i, r);
    
    i = 3;
    r = ++i + ++i * i++;
    //     4 + (5 * 5)
    
    System.out.printf("i = %d , r = %d\n", i, r);
  
  }
}
