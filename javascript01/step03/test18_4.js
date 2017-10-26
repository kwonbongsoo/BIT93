/* 주제: try ... catch ...
=> throw 명령어가 던지는 예외 정보를 받아서 처리하는 문법
=> 목적?
   예외가 발생하더라도 시스템을 멈추지 않고 계속 수행하게 만드는것
*/
"use strict"
//throw 적용전

function divide(a, b) {
  if (b == 0) { //0으로 나누려 한다면,
    throw {errorCode: 400, message: '0으로 나눌수 없다.'}
  }
  return a / b
}
try {
  var result = divide(1212121212, 0)
  console.log('----------------------------------------');
  console.log(result)
} catch (error) {
  console.log(error.message)
}
