/* 주제: 흐름 제어문 - switch ~ case
- 복잡한 조건에 따라 실행 흐름을 제어할 떄는 if를 사용한다.
- 조건이 단순할 때는 switch 문을 사용하는 것이 편리하다.
- 문법
*/
"use strict"

var level;

// switch를 사용 하기전
// 사원 = 워드 자격증
// 개발자 = 워드 자격증 + 정보처리기사 자격증
// 팀장 = 워드 자격증 + 정보처리기사 자격증 + 석사 학위
level = "개발자";
if(level == "사원")
 console.log("워드 자격증 소지자");
if(level == "개발자"){
  console.log("워드 자격증 소지자");
  console.log("정보처리기사 자격증 소지자");
 }
if (level == "팀장"){
  console.log("워드 자격증 소지자");
  console.log("정보처리기사 자격증 소지자")
  console.log("석사 학위자");
 }
console.log("-----------------------------------");
 //switch 문 사용
 level = "개발자";

 switch(level){
   case "팀장":console.log("석사 학위자");
   case "개발자":console.log("정보처리기사 자격증 소지자");
   case "사원":console.log("워드 자격증 소지자");
 }
