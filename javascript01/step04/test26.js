/* 주제:함수 - 재귀호출
- 함수를 호출한 후 다시 자기 자신을 호출하기
- 코드가 간단해 진다.
- 반복문을 사용하기 보다 속도가 느리다. 메모리를 많이 사용한다.
- 너무 깊게 호출하면 스택 메모리가 부족하여 오류가 발생할 수 있다.

*/
"use strict"

// Sigma(n)을 반복문으로 구현하기

var sum=0;

for (var i = 1;i <= 5; i++) {
  sum += i
}
console.log(sum)
console.log('----------------------------------');

//Sigma(n)을 재귀 호출로 구현하기

function sigma(n) {
  if(n == 1)
    return 1;
  return n + sigma(n -1)
}
var sum2 = sigma(5)
console.log(sum2)

// 함수는 스택메모리 영역에 저장된다
// 글로벌 변수는 메모리 heap영역에 저장된다.
// 명령어는 메모리 code 영역에 저장된다.