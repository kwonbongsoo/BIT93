/* 주제: 예외처리 -연습
- 프로그램을 실행하는 도중 예외 상황이 발생했을 때,
  예외 정보를 호출할 쪽에 알리는 명령어
*/
"use strict"
//throw 적용전

function divide(a, b) {
  if (b == 0) { //0으로 나누려 한다면,
    return -1212121212//리턴 값으로 나오기 희박한 수를 리턴한다
  }
  return a / b
}


var result = divide(10, 5)
if (result == -1212121212) {
  console.log('0으로 나눌 수 없습니다')
}else {
  console.log(result)
}
//throw 명령이 없던 시절
