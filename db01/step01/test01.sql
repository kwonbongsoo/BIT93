/* 데이터 조회 명령
select 가져올 칼럼
from 데이터가 저장된 테이블
where 조회 조건
*/

/*
 테이블에 모든 데이터와 모든 컬럼 값을 가져오기
*/

select * from memb;

/* 테이블의 칼럼 정보 추출 */
describe memb;
desc memb;


/* pri 값이 중복되지 않게 하기 위한셋팅 */


/* distinct 키워드 */
select lano, lno, sno, rdt, stat from lect_appy;
/* distinct 키워드  사용전
 => 수강 신청된 과목의 신청번호와 과목번호를 출력하라.
*/

select lano, lno from lect_appy;

/* distinct 키워드 사용 후
=> 수강 신청된 과목의 번호만 출력하라. 단 중복을 제거하라
*/
  select distinct lno from lect_appy;

/* => 강의 데이터 중에서 강의실과 매니저 번호를 추출하라. 중복은 제거하라
중복? 강의실번호와 매니저번호가 같은 데이터는 하나만 출력하라.
*/

select distinct crmno, mrno from lect;

/* [all 키워드]
=> distinct 키워드를 쓰지 않으면 기본이 all이다
*/

select lno from lect_appy
select all lno from lect_appy


/*  예) 수강 신청 정보를 다음과 같이 출력하라
lect(강의 정보) ,croom , mgr(매니저 정보), lect_appy(수강신청)
출력 결과:
강의 번호, 강의제목, 교실이름, 매니저이름, 수강생명, 재직여부
*/
