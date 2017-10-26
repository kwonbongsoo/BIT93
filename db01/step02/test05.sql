/* 테이블에 컬럼 변경하기
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


/* 예제 데이터 값 입력 */




  insert into t2 (no, name, gender, height, intro, birthday, regdate)
  values(1, '홍길순', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

  insert into t2 (no, name, gender, height, intro, birthday, regdate)
  values(2, '홍길순1', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

  insert into t2 (no, name, gender, height, intro, birthday, regdate)
  values(3, '홍길순2', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

  /* 컬럼 정의 변경하기 */
  alter table t2
  change column name fst_nm varchar(10),
  add column lst_name varchar(10);


  /* 컬럼의 이름은 그대로 두고 정의만 변경하기 */
  alter table t2
    modify column fst_nm varchar(9)

/* 컬럼의 이름은 그대로 두고 정의만 변경하기
=> 컬럼의 크기를 줄일 때,
   현재 입력된 데이터 보다 같거나 크게 줄이는 경우는 OK!!
   현재 입력된 데이터보다 작게 줄이면 Error
   */
    alter table t2
      modify column fst_nm varchar(3)


/*
=> numeric 타입을 varchar(10) 타입으로 변경
숫자를 문자열로 변환할 수 있기때문에 OK
*/

alter table t2
  modify column height varchar(10);


  /*
   gender 타입을 char(n) 타입을 int 타입으로 변경
   입력되어 있는 값을 모두 int로 바꿀수 있다면 ok
   단 한개라도 바꿀수 없다면 Error
  */

  alter table t2
    modify column gender int;
