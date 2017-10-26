package step02;

public class Test06 {
  public static void main(String[] args) {
    //1) 배열 레퍼런스 변수 선언하기
//    byte arr1[];
    byte[] arr1;
    
    /* 설명
     * => new byte[3]
     *        -> byte 타입의 메모리를 연속하여 3개 준비한다.
     *        -> 그리고 시작 메모리의 주소를 리턴한다.
     */
//    arr1[0] = 10; // arr1 변수의 값을 초기화 시키지도 않고 사용하면, 컴파일 오류
//    arr1 = null;
//    arr1[0] =10;
//    System.out.println(arr1);
//    System.out.println(arr1[0]);
    //2) 배열을 생성하여 그 주소를 레퍼런스에 담기
   arr1 = new byte[3];
     /* => byte[] arr1
     *        -> byte 배열의 주소를 저장할 변수를 선언한다.
     *        -> '레퍼런스 변수' 또는 줄여서 '레퍼런스'라고 부른다.
     *        -> 일반적인 값을 저장할 수 없다.
     */
   
   //3) 배열에 값 담기
   arr1[0] = 10;
   arr1[1] = 20;
   arr1[2] = 30;
//   arr1[3] = 40;
   System.out.printf("%d, %d, %d ", arr1[0], arr1[1], arr1[2]);
  }
}
/* 배열 변수
 * => 같은 타입의 메모리를 연속적으로 만들 때 사용하는 문법
 */