/* 주제:함수 - 함수 호이스팅(hoisting) II
- 변수 선언에 초기화 문장이 있을때,
  변수 선언만 호이스팅 된다.
*/
"use strict"

console.log(name); // 선언만 호이스팅하기떄문에 undefined가 뜬다.
var name = "홍길동";// 변수선언만 호이스팅함
console.log(name);
