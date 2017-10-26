/* 문장: 반복문\*/
package step04;

public class Test03_9 {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    for (int value : arr) {
      System.out.print(value + ",");
    }
    System.out.println();
    System.out.println("----------------------------------------------------");
    
    // for (변수 선언 : Collection 타입)
    java.util.ArrayList arr2 = new java.util.ArrayList();
    arr2.add(10);
    arr2.add(20);
    arr2.add(30);
    
    for (Object value : arr2) {
      System.out.print(value + ",");
    }
    System.out.println();
  }
}