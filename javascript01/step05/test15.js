/* 주제: 객체 - prototype
- 객체들이 공동으로 사용하는 함수나 변수는 prototype에 보관하면
  각 객체 별로 중복해서 생성할 필요가 없어 메모리가 절약된다.
- 모든 생성자는 prototype 객체를 갖고 있다.
- 문법
 생성자.prototype.변수 = 값
 생성자.prototype.함수 = function(...) {...}

 - 아니 어떻게 함수에 값을 저장할 수 있나요?
    => 자바스크립트에서는 함수도 객체이다.
    => 따라서 객체처럼 사용할 수 있다.
*/
"use strict"

function Calculator() {
  this.result = 0
}
//prototype에 보관되는 함수들은 객체에 대해 사용될 함수들이다.
//객체없이 사용할 수 없다
Calculator.prototype.plus = function (value) {this.result += value}
Calculator.prototype.minus = function(value) {this.result -= value}
Calculator.prototype.multiple  = function(value) {this.result *= value}
Calculator.prototype.divide = function(value) {this.result /= value}

var c1 = new Calculator()
var c2 = new Calculator()
var c3 = new Calculator()

c1.plus(10)
//this는 객체의 주소를 말한다. c1의 주소
c2.minus(20)
c3.plus(30)
console.log(c1.result, c2.result, c3.result)
//prototype에 저장된 함수를 직접 호출한다면?
//this 변수는 plus()를 호출할 때 앞쪽에 준 객체 주소가 저장된다.
//이렇게 사용하려고  plus()를 prototype에 저장한 것이 아니다.
//이런 아무런 의미없는 코드는 작성하지 말라!
console.log(Calculator.prototype.plus(10))
//프로토타입은 객체들이 공동으로 쓸수잇는 타입을 보관해둔것이다.
