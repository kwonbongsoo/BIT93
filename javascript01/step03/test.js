/*주제:a와 b값을 입력 받아서 +.-,*,/,%를하는 프로그램
*/
"use strict"


  let prompt = require('prompt');
  prompt.start();//프롬프트시작while(c!='x'){

  //사용자로부터 'name'과 'tel'을 입력받기
  /* prompt.get(입력받을 항목들의 배열,입력받은 후에 호출될 함수)

  */
  prompt.get(['a','b','c'],function(err,result){console.log("okok");

    var a = parseInt(result.a); //(String을 Number로 바꾼다
    var b = parseInt(result.b);//(String을 Number로 바꾼다
    var c = result.c;
    switch (op) {
      case '+':console.log("a + b = ",a+b);break;
      case '-':console.log("a - b = ",a-b);break;
      case '*':
      case 'x':console.log("a * b = ",a*b);break;
      case '/':console.log("a / b = ",a/b);break;
      case '%':console.log("a % b = ",a%b);break;
      default: console.log("산술연산자를 잘못입력하셨습니다.");

    }
  });
