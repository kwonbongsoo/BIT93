/* 테이블에 컬럼 추가하기
*/


/* 방법3) 테이블을 정의한 후 PK 여부를 지정하기*/


create table t2 (
  no int,
  name varchar(10),
  gender char(1),
  height numeric(4, 1),
  intro text,
  birthday date,
  regdate datetime
);

alter table t2
  add constraint primary key (no);

/* 테이블에 컬럼을 추가하기 */

alter table t2
  add column tel varchar(10)


alter table t2
  add column fax varchar(10),
  add column email varchar(50),
  add column mobile varchar(10);

/* 테이블에 있는 컬럼 제거하기 */
alter table t2
 drop column email;

 /* column 은생략가능 */
 alter table t2
  drop fax;
