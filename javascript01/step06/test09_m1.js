/* 주제: exports를 함수 객체로 대체하기 II
*/
"use strict"

//객체를 리턴함.....
module.exports = function() {
  return {
      result: 0,
      plus(value) {this.result += value},
      minus(value) {this.result -= value},
      multiple(value) {this.result *= value},
      divide(value) {this.result /= value}
  }
}
