/* alias
=> 칼럼의 값을 추출할 때 이름을 지정하지 않으면 컬럼 이름을 그대로 사용한다.
=> 만약 컬럼 이름을 다른 이름으로 바꾸고 싶다면 별명을 지정하라.
=> 문법
select 컬럼명 as 별명, ....
from ~
*/

/* 컬럼에 별명을 부여하기
=> 별명에 공백이 있으면 따옴표('' 또는 "")로 감싸야 한다.
*/
select lno, crmno as ClassRommNo, mrno managerNo, titl as 'class name'
from lect;

/* 컬럼의 이름이 적합하지 않은 경우
   코드에서 사용하기 쉽도록 이름을 지정한다.
*/
select count(*) from lect;
select count(*) cnt from lect;
select count(*) as cnt from lect;
/* count(*) 의 별명으로서 cnt 로 지정하겠단말임 출력할때 cnt가나옴 */
select concat('(', lno, ':', titl, '-', mrno, ')')  lectureInfo from lect;
/* lectureInfo는 별명이다 */
select concat('(', lno, ':', titl, '-', mrno, ')') as lectureInfo from lect;

/* concat() 여러 인자 값과 문자열들을 합하여 출력시키고 싶을때 쓰는 함수
