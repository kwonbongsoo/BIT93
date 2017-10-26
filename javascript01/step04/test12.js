/* 주제:함수 - 함수를 리턴 받기
- 함수를 값처럼 리턴 받을 수 있다.
*/
"use strict"

function calculator(op) {
  switch (op){
    case '+':
      //익명 함수를 정의한 후 그 익명 함수의 주소를 리턴한다.
      return function(a, b) {return a + b;};
      break;
    case '-':
      //익명 함수를 정의한 후 그 익명 함수의 주소를 리턴한다.
      return function(a, b) {
        return a - b;
      };
      break;
  }
}
var f = calculator("+"); //함수를 생성하여 주소를 f 에 주소를 넣는다
var value = f(10,20); //익명함수를 변수로서 함수를 호출하여 value 값을 리턴받는다
console.log(value);

f = calculator("-");
value = f(10,20);
console.log(value);

// 실무에서는 리턴 받은 함수(의 주소)를 바로 사용하는 경우가 많다.
value = calculator("-")(30,20);
console.log(value);

//바로 출력할수 있다.

console.log(calculator("+")(50,30));
