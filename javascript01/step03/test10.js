/* 주제: 흐름 제어문 - switch의 조건값
- case 에 지정할 수 있는 값의 종류

*/
"use strict"

var level;

 switch(NaN){
   case "문자열":console.log("문자열가능");break;
   case 1:console.log("숫자가능");break;
   case 3.14159:console.log("부동소수점 가능"); break;
   case true:console.log("boolean값가능");break;
   case undefined:console.log("undefined가능");break;
   case null:console.log("null가능");break;
   case NaN: console.log("NaN가능");break;//NaN는 직접비교할수 없다
   //isNaN(); 함수로 비교해야한다.
 }
  console.log("-----------------------------------");

  var v = NaN;

  if(v == NaN)
    console.log("NaN다");
