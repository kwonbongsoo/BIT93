package step05;
/* 메서드 : 메서드를 정의하는 문법 */
public class Test02 {
  //1) 값을 리턴하지 않고, 파라미터를 받지 않는다.
  //=> 값을 리턴하지 않을 때는 반드시 메서드 선언 앞에 void를 붙여야 한다.
  //=> 아규먼트를 받지 않는다면 빈 채로 두어야 한다.
  public static void m1() {
    System.out.println("m1()");
  }
  
  //2) 값을 리턴하지 않고, 아규먼트는 받는다.
  //=> 아규먼트 (argument)? 함수를 호출 할 때 넘겨주는 값
  //=> 파라미터(parameter)? 메서드가 호출될 때 넘어온 값을 받는 로컬 변수
  //    그러나 현장에서는 두 용어를 구분하지 않고 섞어 쓴다.
  public static void m2(int a, String str, boolean b) {
    System.out.printf("%d, %s, %b\n", a, str, b);
  }
  
  public static String m3() {
    return "Hello";
    //System.out.println("안되")//안된다;
  }
  //3) 값을 리턴하고, 아규먼트를 받지 않는다.
  //=> 따라서 reutrn 문장 다음에 명령문을 작성해서는 안된다.
  
  
//4) 값을 리턴하고, 아규먼트를 받는다.
  //=> 보통 값을 받아서 처리한 후 그 결과를 리턴하고자 할 때 사용한다.
  public static int m4(int a) {
    return a * a;
  }
  public static void main(String[] args) {
    m1();
    m2(10, "홍길동", false);
    String value = m3();
    System.out.println(value);
    int result = m4(16);
    System.out.println(result);
  }
  
  
}
