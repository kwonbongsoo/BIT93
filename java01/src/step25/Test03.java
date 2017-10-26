/* 애노테이션 추출하기
 * => RUNTIME 레벨의 애노테이션만 추출할 수 있다.
 */
package step25;

public class Test03 {

  public static void main(String[] args) throws Exception{
    // .class 파일에 들어있는 애노테이션을 추출하려면 
    // 1) 클래스 정보를 다루는 도구를 가져와야 한다.
    /* 방법1: 
    Class clazz = Class.forName("step25.Class01");
     */
    
    /* 방법2: */
     Class clazz = Class03.class;
     
     // 2) Class 객체를 통해 애노테이션을 추출한다.
     Annotation05 anno = (Annotation05) clazz.getAnnotation(Annotation05.class);
     if (anno == null) {
       System.out.println("Annotation05 애노테이션을 추출하지 못했다.");

     } else {
       System.out.println("Annotation05 애노테이션을 추출");
       System.out.println("v1 : " + anno.v1()[0]);
       System.out.println("v2 : " + anno.v2()[0]);
       System.out.println("v3 : " + anno.v3()[0]);
       System.out.println("v4 : " + anno.v4()[0]);
       System.out.println("v5 : " + anno.v5()[0]);
       System.out.println("v6 : " + anno.v6()[0]);
     }
    
  }
  

}
