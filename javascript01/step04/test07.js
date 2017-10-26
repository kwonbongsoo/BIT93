/* 주제:함수 - arrow function
- 함수 정의를 축약한 문법
*/
"use strict"

// 익명함수

var f1 = function(){
  console.log("익명함수...");
}
// arrow 함수 정의
// -ECMAScript 2015 버전에서 추가된 문법
var f2 = () =>{console.log("Arrow 함수")}
var f3 = () => console.log("Arrow 함수2"); //문장이 한 개 일때 중괄호 생략가능
f1();
f2();
f3();
