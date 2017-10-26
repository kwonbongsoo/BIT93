
package step03;

public class Test01_2 {

  public static void main(String[] args) {
   int a = 5;
   int b = 2;
   float f = a / b; //int 변수들의 연산 결과는 int 이다
   
   System.out.println(f);
   
   float f2 = (float)a / (float)b;
   System.out.println(f2);
   
   float f3 = (float)a / b;
   System.out.println(f3);
  }
}
