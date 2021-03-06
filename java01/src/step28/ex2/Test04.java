/* Mybatis 퍼시스턴스 프레임 워크 사용
 * 1) mybatis 라이브러리 파일 가져오기
 *    - mvnrepository.com 에서 "mybatis" 검색
 *    - build.gradle 파일에 의존 라이브러리 설정 추가
 *    - "gradle eclipse" 실행하여 이클립스 설정 갱신
 *    - 프로젝트 "refresh"
 * 2) mybatis 사용자 안내 문서확인
 *  - www.mybatis.org 방문
 * 3) SqlSessionFactory 객체를 준비한다.
 * 4) MemberDao SqlSessionFactory
 */
package step28.ex2;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test04 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("step28/ex2/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    

 
    MemberDaoImpl memberDao = new MemberDaoImpl();
    memberDao.setSqlSessionFactory(sqlSessionFactory);
    Member member = new Member(); 
    member.email = "011";
    member.name = "000aksdjfkasfd";
    member.tel ="010-1111-1111";
    member.password = "011";
    System.out.println(memberDao.insert(member));
    
    // insert, update, delete 한 후에는 
    // DBMS에 최종명령을 보내야 실행이 완료된다
    
  }

}
