/* 주제: 흐름 제어문 - 조건문 if ~ else if ~ else if ~ else
- 문법
if (식)   <-- 식의 결과가 참이면 '명령문1'이 실행되고, 거짓이면 '명령문2'가 실행된다.
  명령문1;
else
  if(식)<--- 식의 결과가 참이면 '명령문2'가 실행되고,

  명령문2
*/
"use strict"

var age;

age = 11;

if(age < 8)
  console.log("유아");
else {
  if(age >= 8 && age < 14)
    console.log("어린이");
  else // <-- age가 14이상일때
    console.log("청소년 이상입니다");
}

console.log("---------------------------");

//if ~else ~ 는 한 그룹으로 취급한다.

age = 40;

if(age < 8)
  console.log("유아");
else
  if(age >= 8 && age < 14)
    console.log("어린이");
  else // <-- age가 14이상일때
    console.log("청소년 이상입니다");
console.log("---------------------------");

age = 67;

if(age < 8)
  console.log("유아");
else
   if(age >= 8 && age < 14)
  console.log("어린이");
else
   if(age >= 14 && age <20)
  console.log("청소년 이상입니다");
else
   if(age >= 20 && age <65)
  console.log("성인");
else
  console.log("노인");
console.log("---------------------------");

//실무에서는 if ~ else ~ 문장을 보기 좋게 정렬 한다
//주의!
//- if ~ else if ~ else if ~ else 라는 문법은없다.
//- 그냥 if ~ else 코드를 정리한것 뿐이다.

age = 67;

if(age < 8)
  console.log("유아");
else if(age >= 8 && age < 14)
  console.log("어린이");
else if(age >= 14 && age <20)
  console.log("청소년 이상입니다");
else if(age >= 20 && age <65)
  console.log("성인");
else
  console.log("노인");
console.log("---------------------------");
