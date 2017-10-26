/* 애노테이션 추출하기
 * => RUNTIME 레벨의 애노테이션만 추출할 수 있다.
 */
package step25;

public class Test02 {

  public static void main(String[] args) throws Exception{
    // .class 파일에 들어있는 애노테이션을 추출하려면 
    // 1) 클래스 정보를 다루는 도구를 가져와야 한다.
    /* 방법1: 
    Class clazz = Class.forName("step25.Class01");
     */
    
    /* 방법2: */
     Class clazz = Class02.class;
     
     // 2) Class 객체를 통해 애노테이션을 추출한다.
     Annotation04 anno = (Annotation04) clazz.getAnnotation(Annotation04.class);
     if (anno == null) {
       System.out.println("Annotation04 애노테이션을 추출하지 못했다.");

     } else {
       System.out.println("Annotation04 애노테이션을 추출");
       System.out.println("v1: "+anno.v1() + " v2: " + anno.v2() + " v3: " + anno.v3() + " v4: " + anno.v4());
     }
     Annotation03 anno03 = (Annotation03) clazz.getAnnotation(Annotation03.class);
    
  }
  

}
