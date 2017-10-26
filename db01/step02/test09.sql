/* auto_increment 옵션
=> PK 컬럼에 대해 자동증가 기능을 붙이기
=> PK 컬럼이 아닌 경우 auto_increment를 붙일 수 없다.
*/


/* 1) 테이블 정의할 때  auto_increment 붙이기*/


create table t2 (
  no int primary key auto_increment,
  name varchar(10),
  email varchar(50)
);






insert into t2 (no, name) values(1, '홍길동');
  /* mysql 에서는 null 중복 허용 한다 */
insert into t2 (no, name) values(2, '임꺽정');

insert into t2 (no, name, email) values(3, '유관순', 'you@test.com');
  /* 기존에 입력된 이메일과 중복된 데이터는 입력할 수 없다.  오류 발생 */
insert into t2 (no, name, email) values(4, '안중근', 'you@test.com');

 /*  not null로 설정된 컬럼의 값은 반드시 입력해야 한다.
    그러나 default  값이 설정되어 있다면 값을 입력안해도됨*/

    insert into t2 (no)
    values(2);


/* not null 로 설정된 컬럼의 값은 반드시 입력해야 한다 */

insert into t2 (no)
values(2);
