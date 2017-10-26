/*주제:a와 b값을 입력 받아서 +.-,*,/,%를하는 프로그램
*/
"use strict"

var prompt = require('prompt');
prompt.start();//프롬프트시작

//사용자로부터 'name'과 'tel'을 입력받기
/* prompt.get(입력받을 항목들의 배열,입력받은 후에 호출될 함수)

*/
prompt.get(['a','b'],function(err,result){
  console.log("입력값 출력 ==================");
  console.log(result.a,result.b);


});
