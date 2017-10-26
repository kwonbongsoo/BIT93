/* 주제: 객체 - defineProperty
read only 적용 후
*/
"use strict"
function Calculator() {

}
let result = 0
Calculator.prototype.plus = function(value) {result += value}
//함수에서 바깥 쪽의 변수를 사용할 때 그 변수가 "로컬 변수" 이거나 "let" 으로
//선언된 변수인 경우, 언제든(함수호출이 끝나거나, 블록을 벗어날때)
// 제거될 수 있는 위험이 있다.
//이런 경우를 해소하기 위해 그 변수의 값을 별도로 클로저가 고나리하는 별도의 영억에
// 복제해 둔다
Calculator.prototype.minus = function(value) {result -= value}
//같은 영역에서 만든 함수는 클로저 메모리 영억을 공유한다
// 따라서 plus 나 minus는 같은 클로저 영역을 공유한다
// plus()가 복제한 result나 minus()가 복제한 result는 같은 변수이다
Calculator.prototype.getResult = function(value) {
  return result
}

var calc1 = new Calculator


calc1.plus(100)
calc1.minus(20)
calc1.plus(10)
//calc1.result = 1000//개발자가   실수로 이렇게 임의적으로 값을 바꾸더라도 막을방법이없다
console.log(calc1.getResult())
