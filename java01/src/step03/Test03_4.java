/* 연산자
 * 
 */
package step03;

public class Test03_4 {

  public static void main(String[] args) {
    int a = 0b1100_1010;
    int b = 0b0101_0101;
    
    int r = a & b; // 0100_0000
    
    System.out.println(Integer.toBinaryString(r));
    
    r = a | b; // 1101_1111
    System.out.println(Integer.toBinaryString(r));
    
    r = a ^ b; // 1001_1111
    System.out.println(Integer.toBinaryString(r));
    
    r = ~a; // 0011_0101
    System.out.println(Integer.toBinaryString(r));
  }
}
