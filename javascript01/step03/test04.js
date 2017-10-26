/* 주제: 흐름 제어문 - 조건문 if ~ else ~
- 문법
if (식)   <-- 식의 결과가 참이면 '명령문1'이 실행되고, 거짓이면 '명령문2'가 실행된다.
  명령문1;
else
  명령문2
*/
"use strict"

var value = 11;

//else 문법 도입 전
if((value % 2) == 0)
  console.log("짝수");
if((value % 2) != 0)
  console.log("홀수");
console.log("----------------------");


//else 문법 도입 후
if((value % 2) == 0)
  console.log("짝수");
else //if 조건이 거짓일때 else에 소속된 문장을 실행한다.
  console.log("홀수");
console.log("----------------------");

//else는 if 없이 실행할 수 없다.
// -else는 항상 if문에 이어서 나와야한다.

if((value % 2) == 0)
  console.log("짝수");
  // console.log("-------------");
  // 이문장이 들어옴으로서 if문이 종료가 되어서 else 와 관련된
  // if 문이 관련이 없으므로 에러가 뜬다...
else //if 조건이 거짓일때 else에 소속된 문장을 실행한다.
  console.log("홀수");
console.log("----------------------");

//위의 문장이 오류가 발생하지 않도록 해결하는 방법

if((value % 2) == 0){
  console.log("짝수");
  console.log("-------------"); 
}
else //if 조건이 거짓일때 else에 소속된 문장을 실행한다.
  console.log("홀수");
console.log("----------------------");
