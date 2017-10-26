/* null 옵션
*/


/* 방법3) 테이블을 정의한 후 PK 여부를 지정하기*/


create table t2 (
  no int,
  name varchar(10), /* 기본이 null 허용 */
  gender char(1) not null,
  height numeric(4, 1),
  intro text,
  birthday date,
  regdate datetime
);

alter table t2
  add constraint primary key (no);


/* 예제 데이터 값 입력 */




  insert into t2 (no, gender)
  values(1, 'W');




/* not null 로 설정된 컬럼의 값은 반드시 입력해야 한다 */

insert into t2 (no)
values(2);
