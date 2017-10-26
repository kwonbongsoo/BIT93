/* 주제:조건연산자(Conditional (ternary)operator)
- 간단하게 조건 명령문을 작성 할떄 사용한다.
- 문법
*/
"use strict"
var a = 11;
console.log((a %2  == 0) ? "짝수입니다":"홀수 입니다");
(a % 2) == 0 ? console.log("짝수"):console.log("홀수");

var c = 10;
console.log("c가 10일때 전치연산",++c);
var b = 10;
console.log("b가 10일떄 후치연산",b++);
console.log("후치연산 세미콜론끝나고 b의값",b);
a = a++;
console.log(a);
