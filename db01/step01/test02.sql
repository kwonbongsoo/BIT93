/*  order by
=> 결과를 정렬할 때 사용한다.
=> 문법
select ~
from ~
where ~
order by ~ 컬럼명 정렬순서d

=> 정렬순서
asc : 오름차준
desc: 내림차순
*/

/* 이름 오름차순  정렬순서를 지정하지 않으면 asc가 디폴트값이다*/
select mno, name, tel, email from memb
order by name asc;

/* 이름 내림차순 */
select mno, name, tel, email from memb
order by name desc;

/* 여러 개의 컬럼을 정렬하기 */
select lano, lno, sno
from lect_appy
order by lno desc, sno asc;

/* 실행 순서 : from -> select -> order by
=> order by 에서 컬럼을 지정할 때, select 선언하지 않은 컬럼을 지정할 수 있다.
=> 이유?
   select는 추출할 항목이 무엇인지 표시하는 일을 한다.
   select를 먼저 처리했다고 해서 컬럼이 추출된 상태는 아니다.
   단지 결과로 출력할 컬럼 값이 무엇인지 표시한 거다.
   그러므로 order by 에서 select에 존재하지 않는 컬럼을 지정할 수 있는 것이다.
*/
select lano, sno
from lect_appy
order by lno asc, sno desc;

/*
1) lect_appy 테이블에서 데이터를 가져올 것이다.
2) 출력할 값은 전체 컬럼에서 lano와 sno로 지정한다
3) 값을 추출하기 전에 정렬한다.
4) 결과 값을 출력한다. 이때 select 지정한 컬럼 값만 추출한다.
*/
