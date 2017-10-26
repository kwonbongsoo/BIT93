/* 주제:함수 - 정의와 사용 II
*/
"use strict"
// - 1) 파라미터 없는 함수
function f1(){
  console.log("f1() 호출 됨");
}

f1();
// - 2) 파라미터 x 리턴 값o
function f2(){
  return "hello";
}
var value = f2();
console.log("f2의 리턴 값은= "+ value);
// - 3) 파라미터 o 리턴 값 x
function f3(a){
  console.log("--->"+a);
}

f3(100);
f3(200);
f3(300);
// - 4) 파라미터 o 리턴 값 o
function f4(a){
  return "a = "+ a + "입니다";
}

var value = f4(100);
console.log(value);

// 굳이 값을 별도의 변수에 저장한 후 출력할 필요는 없다
// 함수의 리턴 값을 즉시 사용할 수 있다.
// 참고! 실행은 항상 괄호() 안쪽부터 실행한다.

console.log(f4(200));
