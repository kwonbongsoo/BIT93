/* Class 도구 사용법 */
package step26;

public class Test02 {

  public static void main(String[] args) throws Exception{

    Class<?> c1 = String.class;
    System.out.println(c1.getName());
    System.out.println(c1.getSimpleName());
    System.out.println(c1.getCanonicalName()); // 표준이름
    
  }
}
