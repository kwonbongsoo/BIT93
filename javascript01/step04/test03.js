/* 주제:함수 - 함수 호이스팅(hoisting) = 끌어올려지다.
- 자바스크립트 엔진은 항상 변수나 함수 정의를 먼저 실행한다.
*/
"use strict"
// f1() 함수를 정의하기 전에 호출

name = "홍길동";
f1();

var name;
console.log(name);
function f1() {
  console.log("f1() 호출됨");
}

// 함수를 정의한 후 f1() 호출
f1();
