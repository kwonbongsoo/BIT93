/* Primary Key 컬럼을 지정하기
방법1) 컬럼을 선언할 때 지정하기
방법2) 테이블 선언 끝ㄴ에 따로 지정하기
방법3) 테이블 선언 후 지정하기
*/

/* 방법1) 컬럼을 선언할 때 pk여부를 지정하기 */


create table t2 (
  no int primary key,
  name varchar(10),
  gender char(1),
  height numeric(4, 1),
  intro text,
  birthday date,
  regdate datetime
);

drop table t2


insert into t2 (no, name, gender, height, intro, birthday, regdate)
values(1, '홍길순', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

/* pk 컬럼은 중복 값을 가질수 없다 primary key = pk */
insert into t2 (no, name, gender, height, intro, birthday, regdate)
values(1, '홍길순', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

/* pk 컬럼은 기본이 not null 이다 반드시 값을 입력해야 한다. */
insert into t2 (no, name, gender, height, intro, birthday, regdate)
values('홍길순', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');


/* 방법2) 컬럼들을 선언한 후 PK 여부를 지정하기*/


create table t2 (
  no int,
  name varchar(10),
  gender char(1),
  height numeric(4, 1),
  intro text,
  birthday date,
  regdate datetime,
  constraint primary key (no)
);


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
/* 테이블을 생성한 후 제약 조건을 추가한다 */
alter table t2
  add constraint primary key (no);
