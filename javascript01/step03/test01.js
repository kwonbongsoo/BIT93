/*주제:사용자에게서 입력받기
 - 외부에서 제공하는 'prompt'라는 nodeJS 모듈(=라이브러리=컴포넌트=플러그인)을
 추가해야 한다. 그래야 NodeJS에서 사용할수 있따.
>npm install 모듈명
>npm install prompt


 - 소스 코드에서 모듈을 사용하려면 Nodejs에게 요구해야한다.
 var 모듈을 가리키는 변수명 = require('모둘명');

*/
"use strict"

var prompt = require('prompt');
prompt.start();//프롬프트시작

//사용자로부터 'name'과 'tel'을 입력받기
/* prompt.get(입력받을 항목들의 배열,입력받은 후에 호출될 함수)

*/
prompt.get(['name','tel'],function(err,result){console.log("okok");
  console.log('입력결과:');
  console.log('이름=',result.name);
  console.log('전화=',result.tell);
});
