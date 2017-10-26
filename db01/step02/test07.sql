/* default 옵션
*/


/* 방법3) 테이블을 정의한 후 PK 여부를 지정하기*/


create table t2 (
  no int,
  name varchar(10) default '홍길동',
  gender char(1) not null default 'W',
  height numeric(4, 1),
  intro text,
  birthday date,
  regdate datetime
);

alter table t2
  add constraint primary key (no);


/* 예제 데이터 값 입력 */




insert into t2 (no, gender)
values(1, 'M');

 /*  not null로 설정된 컬럼의 값은 반드시 입력해야 한다.
    그러나 default  값이 설정되어 있다면 값을 입력안해도됨*/

    insert into t2 (no)
    values(2);


/* not null 로 설정된 컬럼의 값은 반드시 입력해야 한다 */

insert into t2 (no)
values(2);
