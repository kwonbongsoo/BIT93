/* 문장: 반복문 while - break; */
package step04;

public class Test03_2 {

  public static void main(String[] args) {
    int i = 2;
    int j = 1;
    int r = 0;
    
    while (i <= 9) {
      j = 1;
      while (j <= 9) {
        System.out.printf("%d x %d = %d\n",i, j, (i * j));
        j++;
      }
      i++;
      System.out.println("----------------------------------------------");
    }
  }
}