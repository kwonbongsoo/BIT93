/* sql(Stuctured Query Language)
=> DML(Data Manipulation Language)
   select, insert, update, delete
   오라클에서는 select를 DQL(Data Query Language)라 부르기도 한다.
=> DDL (Data Definition Language)
  => 데이터베이스/테이블/뷰/함수/프로시저 등을 생성,변경 삭제하는 명령
*/


/* 테이블 생성 및 삭제
   => 문법
   create table t1 (
    컬럼명 타입 옵션
    ...
   )
   drop table 테이블명
   */

create table t1 (
  no int,
  name varchar(255)
)

drop table t1
