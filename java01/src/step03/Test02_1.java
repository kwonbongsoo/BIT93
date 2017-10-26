/* 증가 / 감소 연산자 - 전위 연산자
 * 
 */
package step03;

public class Test02_1 {
  public static void main(String[] args) {
    //1) 전위(pre-fix) 연산자
    int i = 10;
    ++i;
    System.out.println(i);
    --i;
    System.out.println(i);
    
    //2) 후위(post-fix) 연산자
    i = 10;
    i++;
    System.out.println(i);
    i--;
    System.out.println(i);
  }
}
