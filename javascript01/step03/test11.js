/* 주제: 흐름 제어문 - 연습
- 사용자로부터 숫자 a,b와 연산자 op 값을 받아서 계산 결과를 출력하는프로그램
*/
"use strict"

var prompt = require('prompt');
prompt.start();//프롬프트시작

//사용자로부터 'name'과 'tel'을 입력받기
/* prompt.get(입력받을 항목들의 배열,입력받은 후에 호출될 함수)

*/
prompt.get(['a','b','c'],function(err,result){console.log("okok");

  var a = parseInt(result.a); //(String을 Number로 바꾼다
  var b = parseInt(result.b);//(String을 Number로 바꾼다
  var op = result.c;
  console.log("계산결과:");
  switch (op) {
    case '+':console.log(a,op,b,"=",a+b);break;
    case '-':console.log(a,op,b,"=",a-b);break;
    case '*':
    case 'x':console.log(a,op,b,"=",a*b);break;
    case '/':console.log(a,op,b,"=",a/b);break;
    case '%':console.log(a,op,b,"=",a%b);break;
    default: console.log("잘못입력하셧네요 ㅗ");

  }
});
