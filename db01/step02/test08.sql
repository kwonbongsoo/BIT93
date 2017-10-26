/* unique 옵션
=> primary key 는 아니더라도 PK처럼 중복 데이터 입력을 막고 싶을 때 사용한다.
*/


/* 방법3) 테이블을 정의한 후 PK 여부를 지정하기*/


create table t2 (
  no int,
  name varchar(10),
  email varchar(50)
);

alter table t2
  add constraint primary key (no);
/* 기존의 pk 컬럼을 auto_increment로 만들기 */

  alter table t2
    modify column no int auto_increment;

  create table t2 (
    no int,
    name varchar(10),
    email varchar(50)
  );

  alter table t2
    add constraint primary key (no);







insert into t2 ( name, email) values( '유관순', 'you@test.com');
  /* 기존에 입력된 이메일과 중복된 데이터는 입력할 수 없다.  오류 발생 */
insert into t2 (name, email) values( '안중근', 'you@1test.com');
  insert into t2 (name, email) values( '엄진영', 'eom@1test.com');


delete from t2 where no=1;
/* 중간에 번호가 빠져있다고 해서 중간 번호를 채우면서 증가하지 않는다.
항상 가장 큰 값으로 번호 값으로 정해진다. */
insert into t2 (no)
values(2);
