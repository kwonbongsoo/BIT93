/* 문장: 반복문 while - break; */
package step04;

public class Test03_5 {

  public static void main(String[] args) {
    int i = 2;
    int j = 1;
    int r = 0;
    
    while (i <= 9) {
      j = 1;
      while (j <= 9) {
        System.out.printf("%d x %d = %d\n",i, j, (i * j));
        if (i == 5 && j == 5)
          break;
        j++;
      }
      i++;
      System.out.println("----------------------------------------------");
    }
  }
}