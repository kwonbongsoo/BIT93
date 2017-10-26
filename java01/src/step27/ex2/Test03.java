/* 스프링 사용법 : Spring IoC 컨테이너 준비 1
 *  => 스프링 IoC 컨테이너를 사용하기 위한 라이브러리 준비
 *      1) mvnrepository.com 에서 "spring-context" 검색
 *      2) build.gradle에 의존 라이브러리 정보 추가
 *      3) "gradle eclipse" 실행하여 이클립스 관련 설정 파일을 갱신
 *      4) 이클립스 프로젝트를 "refresh"한다.
 */
package step27.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) {

    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex2/application-context-03.xml");
    System.out.println(ctx.getBean("c1"));
    System.out.println(ctx.getBean("c2"));
    System.out.println(ctx.getBean("c3"));
    System.out.println(ctx.getBean("c4"));
  }
}
