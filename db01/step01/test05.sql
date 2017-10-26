/* 조인
=> 서로 관련된 테이블의 데이터를 연결하여 추줄하는 방법
=> 기법
 1) CROSS 조인 = cartition 조인
 2) NATURAL 조인
 3) JOIN ~ ON
 4) OUTER JOIN

*/

select mno, name, tel, email from memb;

select sno, work, lst_schl, schl_nm from stud;

/* 1) CROSS 조인
    => 각 테이블의 데이터를 1:1로 연결하는 것
    => 최종 결과는 n *  m 개수가 된다.
    => 아무 의미 없는 조인이다
*/

select mno, name, sno, work, lst_schl
from memb, stud;

/* 두 테이블의 컬럼의 이름이 겹치면 오류가 발생한다.
=> 그럴 경우 테이블에 별명을 부여하라!
=> 그리고 컬럼을 지정할 때 테이블의 별명을 붙여라.
*/

select m.mno, m.name, s.sno, s.work, s.lst_schl
from memb as m, stud as s;

select m.mno, m.name, s.sno, s.work, s.lst_schl
from memb m, stud s;

/* 표준 문법 */

select m.mno, m.name, s.sno, s.work, s.lst_schl
from memb m cross join stud s;

/*  2) NATURAL 조인
=> 두 테이블을 조인할 때 같은 이름을 가진 컬럼이 있을 경우,
   그 컬럼 값이 같은 것 끼리 연결한다.
*/

/* 강의 - 교실 조인 : CROSS JOIN */
select lno, crmno, titl, name
/* 실행 오류 ! crmno 의 소속을 알 수 없다 */
from lect cross join croom;

/* => 소속이 헷갈리는 컬럼에만 테이블의 별명을 지정하면 된다. */

select lno, l.crmno, titl, name
from lect l cross join croom c;

/* => 실무에서는 헷갈리지 않더라도 어떤 컬럼이 어떤 테이블에 있는지
      개발자에게 명확히 알리기 위해 무조건 테이블 별명을 붙인다.*/
select
  l.lno,
  l.crmno,
  l.titl,
  c.name
from lect l cross join croom c;

/* 예) 강의 - 교실 조인 : NATURAL JOIN */

select
  l.lno,
  l.crmno,
  l.titl,
  c.crmno,
  c.name
from lect l cross join croom c
where l.crmno = c.crmno;

/* 두 테이블의 데이터를 연결할 때, 같은 이름의 컬럼을 찾아서
   그 컬럼의 값이 같은 것 끼리 자동으로 묶는다.*/
select
  l.lno,
  l.crmno,
  l.titl,
  c.crmno,
  c.name
from lect l NATURAL join croom c




   /*  => 두 테이블을 natural join 하기 위해서는 같은 이름의 컬럼이 있어야 한다.
          그러나 lect과 stud 처럼 같은 이름의 컬럼이 없으면,
          그냥 cross join 이 돼 버린다.
   */

   select m.mno, m.name, s.sno, s.work, s.lst_schl
   from memb m NATURAL join stud s;

   /* 이렇게 컬럼 이름이 다른 경우에는 어떤 컬럼으로 조인할 지 where 절에 정확하게 지정해야 한다. */
select m.mno, m.name, s.sno, s.work, s.lst_schl
from memb m cross join stud s
where m.mno = s.sno;
/* 3) JOIN ~ ON
    =>조인할 테이블의 컬럼 이름이 다를 경우 사용한다. */

    select m.mno, m.name, s.sno, s.work, s.lst_schl
    from memb m join stud s on m.mno = s.sno;
/* 이렇게 일치하는 데이터끼리 묶는 것을 inner 조인이라 부른다
   위의 문법이랑 같다!
    inner 생략가능*/

    select m.mno, m.name, s.sno, s.work, s.lst_schl
    from memb m inner join stud s on m.mno = s.sno;


  /* 4) outer 조인
    => inner join의 문제점을 해결하기 위해 나온 문법이다.
    => inner join의 문제점? 일치하는 데이터가 있을 때 결과로 추출될 수 있다.
    없다면 결과에 포함되지 않는다.
    */


    /* 예) 겨로가에 포함되지 않아서 문제가 발생하는 경우
        => 강의 번호, 제목, 교실 이름을 출력하시오
    */
select l.lno, l.titl, c.name
from lect l inner join croom c on l.crmno = c.crmno

/* 위으 질의문은 강의실이 배정안된 강의가 결과에서 누락되는 문제가 있다. */

/* 조인할 때 일치하는 데이터가 없더라도 결과에 포함시키는 방법?
  => outer join 이다
  => 결과에 반드시 포함시켜야 할 태이블을 지정하라
 */

 select l.lno, l.titl, c.name
 from lect l right outer join croom c on l.crmno = c.crmno;

 select l.lno, l.titl, c.name
 from lect l left outer join croom c on l.crmno = c.crmno;


 /*  예) 수강 신청 정보를 다음과 같이 출력하라
 lect(강의 정보) ,croom(강의실) , mgr(매니저 정보), lect_appy(수강신청)
 stud(학생) , memb(회원기본정보)
 출력 결과:
 강의 번호, 강의제목, 교실이름, 매니저이름, 수강생명, 재직여부
 */
  select la.lano, l.titl, cr.name, m.name, mr.posi, m2.name, s.work
  from lect_appy la
  inner join lect l on la.lno = l.lno
  left outer join croom cr on l.crmno = cr.crmno
  left outer join memb m on l.mrno = m.mno
  left outer join mgr mr on l.mrno = mr.mrno
  left outer join memb m2 on la.sno = m2.mno
  left outer join stud s on la.sno = s.sno
