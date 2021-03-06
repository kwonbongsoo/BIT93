/* 애노테이션;
 * => 클래스 앞, 필드 앞, 메서드 앞에 붙이는 특별한 주석이다.
 * => 컴파일러나 JVM에서 꺼내쏜다.
 * => 특정 값을 갖도록 형식을 정의할 수 있다.
 * => 문법은 인터페이스와 유사하다
 * => 애노테이션의 유지 범위를 다음과 같이 지정할 수 있다.
 *      1) SOURCE 
 *          - 소스 코드에서만 유지된다.
 *          - 컴파일할 때 제거된다.
 *          - 즉 .class 파일에 해당 주석이 존재하지 않는다.
 *      2) CLASS
 *          - 컴파일 한 후에도 .class 파일에 남아 있다.
 *          - 그러나 JVM에서 꺼내 쓸 수 없다.
 *          - 애노테이션의 유지 범위를 지정하지 않으면 기본이 CLASS이다.
 *      3) RUNTIME
 *          - 컴파일 한 후에도 .class 파일에 남아 있다.
 *          - JVM을 통해 실행 중에 그 내용을 추출할 수 있다.
 */
package step25;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 유지 범위를 지정하지 않으면 다음의 애노테이션이 자동으로 붙는다.
//@Retention(RetentionPolicy.CLASS)
public @interface Annotation01 {
  
}
