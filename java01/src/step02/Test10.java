/* 배열 응용
 */
package step02;

public class Test10 {
  public static void main(String[] args) {

    byte[][] arr1 = new byte[3][2];
    
   arr1[0][0] = 10;
   arr1[0][1] = 20;
   arr1[1][0] = 30;
   arr1[1][1] = 40;
   arr1[2][0] = 50;
   arr1[2][1] = 60;
   
   for (int i = 0; i < 3; i++) {
     for( int j = 0; j < 2; j++)
       System.out.printf("%d\n",arr1[i][j]);
   }
   
   byte[] arr2 = arr1[0];
   arr1[0][0] = 30;
   System.out.println("-------------------------------------");
   System.out.printf("%d, %d\n", arr2[0], arr2[1]);
   
   arr2 = arr1[1];
   System.out.printf("%d, %d\n", arr2[0], arr2[1]);
   
   arr1[1] = new byte[]{100, 101, 102};
   System.out.printf("%d %d %d\n",arr1[1][0],arr1[1][1],arr1[1][2]);
  }
}
