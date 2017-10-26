/* 주제: 객체 - 객체와 함수호출
*/
"use strict"

function Calculator() {
  this.result = 0
  this.plus = function(value) {this.result += value}
  this.minus = function(value) {this.result -= value}
  this.multiple = function(value) {this.result *= value}
  this.divide = function(value) {this.result /= value}
}

var c1 = new Calculator()
var c2 = new Calculator()
var c3 = new Calculator()

c1.plus(10)
//this는 객체의 주소를 말한다. c1의 주소
c2.minus(20)
c3.plus(30)
