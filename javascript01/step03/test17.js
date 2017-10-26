/* 주제: 흐름 제어문 -연습
- 구구단을 출력하는 프로그램을 작성하시오

*/
"use strict"

var prompt = require('prompt');
prompt.start();//프롬프트시작

//사용자로부터 'name'과 'tel'을 입력받기
/* prompt.get(입력받을 항목들의 배열,입력받은 후에 호출될 함수)

*/
prompt.get(['step'],function(err,result){console.log("okok");
  var step = parseInt(result.step); //(String을 Number로 바꾼다
    for (var i = 1;i<10;i++)
      console.log(step+" * "+i+" = "+ step*i);
});
