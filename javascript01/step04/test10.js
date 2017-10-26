/* 주제:함수 - 함수를 파라미터로 넘기기
- 함수를 값처럼 주고 받을 수 있다.
*/
"use strict"

function plus(a,b) {
  return a + b;
}
function minus(a,b) {
  return a - b;
}
//plus()나 minus() 함수처럼 다른 함수에 의해 꺼꾸로 호출되는 함수를
//"콜백(callback) 함수"라고 부른다
//콜백 함수의 주소를 저장하는 변수명은 보통 callback의 약자인 "cb"를 사용
function caller(f) {
  var value = f(20, 30); //파라미터로 함수를 넘기는법
  console.log(value);
}

caller(plus);
caller(minus);
