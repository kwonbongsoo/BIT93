/* Class 도구 사용법 : 메서드 호출하기 */
package step26;

import java.lang.reflect.Method;

public class Test09 {
static class My {}  
  public static void main(String[] args) throws Exception{
    Class<?> c1 = My.class;
    Class<?> c2= step26.Test09.My.class;
    Class<?> c3 = Class.forName("step26.Test09$My");
    
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
  }
}
