/* 컬럼의 데이터 타입 지정
=> 문법
int : 정수 값
number : 정수 및 부동 소수점
char(x) : x 개의 문자를 입력할 수 있는 컬럼
         한 개의 문자를 입력하면 나머지 개수만큼 빈문자를 채운다.
         용량이 낭비되는 대신 데이터를  빨리 찾을수 있다.
         최대 255자
varchar(x) : variable character 라는 의미. 최대 x 개의 문자를 입력할 수 있는 컬럼
             한개의 문자를 입력하더라도 입력한 문자 개수 만큼만 채운다.
             용량을 char(x)에 비해 최적화하는 대신 데이터 찾는데 시간이 걸린다.
             최대 255자 까지
    text : 최대65535자까지 입력할 수 있다.
midiumtext : 최대 2**24 1600만자 까지 입력할 수 있다.
longtext : 최대 약 2**32 42억자까지 입력할 수 있다.
 date : 년, 월, 일 날짜 입력
 datetime : 년 월 일, 시 , 분, 초 날짜 및 시간 입력
   */

create table t2 (
  no int,
  name varchar(10),
  gender char(1),
  height numeric(4, 1),
  intro text,
  birthday date,
  regdate datetime
);

drop table t2


/* 테이블 목록 보기 */
show tables;

/* 테이블 상세 정보 보기 */
desc 테이블명
describe 테이블명;

/* 테이블에 값입력 */

insert into t2 (no, name, gender, height, intro, birthday, regdate)
values(1, '홍길순', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

/* no:int => 3.14  입력하면 소수점 이하가 잘려서 들어간다 */
insert into t2 (no, name, gender, height, intro, birthday, regdate)
values(3.14, '홍길순', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');


/* varchar(10) => 12345678901  입력하면 크기가 초과되어 오류 발생*/
insert into t2 (no, name, gender, height, intro, birthday, regdate)
values(3.14, '12345678901', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');
/* 한글 영어 따지지 않고 10자만 가능
=> DBMS에 따라 동작이 다를 수 있다.
*/
insert into t2 (no, name, gender, height, intro, birthday, regdate)
values(3.14, '가나다라마바사아자차', 'W', 160.5, '길순이..', '1993-5-5', '2017-4-17 15:23:11');


/* numeric(4,1) => 최대 4자리 숫자. 소수점 이하 한 자리만 가능
=> 소수점이 2자리면 반올림 처리됨.
*/

insert into t2 (no, name, gender, height, intro, birthday, regdate)
values(6, '홍길동', 'W', 60.57, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

/* 소수점 위의 자릿수가 초과하면 오류! */
insert into t2 (no, name, gender, height, intro, birthday, regdate)
values(6, '홍길동', 'W', 2060, '길순이..', '1993-5-5', '2017-4-17 15:23:11');

/* date => 날짜 정보만 저장됨
=> 시간 정보를 입력해도 날짜 정보만 저장한다.
*/

insert into t2 (no, name, gender, height, intro, birthday, regdate)
values(7, '홍길순', 'W', 160.5, '길순이..', '1993-5-5 7:3:5', '2017-4-17 15:23:11');

/* datetime => 날짜와 시간 정보 저장
=> 시간 정보를 주지 않으면, 0시 0분 0초로 설정된다.
 */
insert into t2 (no, name, gender, height, intro, birthday, regdate)
values(7, '홍길순', 'W', 160.5, '길순이..', '1993-5-5 7:3:5', '2017-4-17');
