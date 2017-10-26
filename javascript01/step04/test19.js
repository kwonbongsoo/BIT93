/* 주제:함수 -함수 호출 동기 방식과 비동기 방식
 동기 방식 호출
 - 일반적으로 대부분의 함수가 동기 방식의 호출이다.
 - 즉 함수 실행이 완료될 때 까지 블로킹이 걸려 있다.
   다음 명령을 실행하지 않는다.
- 함수에서 무한 루프에 빠지면 더 이상 실행할 수 없는 상태가 될 수 있다.
- 함수에서 시간이 오래 걸리면 다음 실행이 오랫동안 지연되는 문제가 발생

비동기 방식 호출
- 서버나 통신이나 파일 입.출력 부분에서 사용된다.
- 함수 실행을 시킨 후, 함수가 작업을 끝날 때 까지 기다리지 않고
  즉시 다음 명령문을 실행하는 방식이다.

*/
"use strict"



function f1() {
  console.log("f1().. 호출됨");
  for(var i = 0; i < 100000; i++) {
    var d = 3.1415792;
    var d2 = 3456.987;
    var result = d / d2 ;
  }
}
//동기 방식 호출 예
f1()
console.log("hello");