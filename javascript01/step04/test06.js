/* 주제:함수 - 익명 함수와 호이스팅
- 변수 선언과 초기화 문장이 함께 있을때
  변수 선언만 호이스팅 된다
*/
"use strict"

f1();
//f2(); //f2 변수는 호이스팅 규칙에 따라 끌어 올려져서 존재하는 상태이지만,
      //익명함수가 저장된 상태는 아니다.
//1)일반적인 함수 정의

function f1() {
  console.log("okok");
}

//2)익명함수를 정의하기
var f2 = function() {
  console.log("익명함수....");
}
var f3 = function() {
  console.log("익명함수2....");
}

f2();

console.log(typeof(f3));
