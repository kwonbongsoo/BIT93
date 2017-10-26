/* 주제:setInterval(callback, delay[,....args])
- 지정된 시간이 지나면 자동으로 호출될 함수를 등록하는 방법
- 계속 반복하게 하는 함수(clearInterval(args) 로 반복을 끝낸다)
- callback : 지정된 시간이 지났을 때 호출될 함수 주소
- delay : 타임아웃 시간(밀리초)
- ... arguments : callback을 호출할 때 넘겨줄 값들
*/
"use strict"
var count = 0


// var timer = setInterval(function() {
//   console.log('1초지남')
//   if(++count == 10 || timer != timer1)
//     clearInterval(timer1) //지정된 타이머를 멈춘다
//     }, 1000)
// 비동기 방식 호출. 3초 후에 호출될 함수를 등록후 바로 리턴한다.
// var timer
// function test() {
//   var timer = setInterval(function() {
//     console.log('1초지남')
//     if(++count == 10)
//       clearInterval(timer) //지정된 타이머를 멈춘다
//       }, 1000)
// }
// test()
// timer = 'ok'
// console.log(timer)



{
  let timer = setInterval(function() {
    console.log('1초지남')
    if(++count == 10)
      clearInterval(timer) //지정된 타이머를 멈춘다
      }, 1000)
}
var timer = 'ok'
console.log(timer)
