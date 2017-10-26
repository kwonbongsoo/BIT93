/* 주제: 흐름 제어문 - 반복문 while
-조건에 따라 명령문을 반복하고 싶을 때 사용한다.
- 문법
while (조건식) 명령문;

while (조건식) <- 조건식의 결과가 true 일 떄 명령문을 반복하여 실행한다.
              <- 조건식의 결과가 false라면 반복을 멈춘다.
 명령문;

 while(조건식){
  명령문1
  명령문2
}
*/
"use strict"
var count = 1;
while(count <=10)
  console.log(count++);

console.log("------------------------");

var a = 2;
while(a<10){
  var b = 1;
  while(b<10)
  console.log(a+" x "+b++ +" = "+(a*b));
   a++;
}
