/* 주제:함수 - 재귀호출 II
- 꼬리 재귀 (recursive call)
  - 재귀 호출 하여 리턴한 값을 계산하지 않고 바로 곧 바로 리턴하도록 만든다.
  - 이런 경우 스크립트 엔진이나 컴파일러가 
    스택 메모리를 과도하게 사용하지 않도록 자동으로 최적화를 수행한다.
  - 최적화를 수행 방법
    1) 일반적인 반복문으로 코드를 바꾸기도 한다.
    2) 스택 메모리를 증가시키지 않고 재사용하기도 한다.
- node js 에서 꼬리 재귀에 대해 최적화를 수행하려면, 다음과 같이 실행할떄
  최적화 옵션을 추가하라 node --harmony test27.js 를 하거나 디버그 설정창에서  
  "runtimeArgs": [
                "--harmony"
            ]를 추가한다.
  꼬리 재귀에 대해 최적화가 이루어지면,
  꼬리 재귀 함수를 호출하더라도 스택 메모리가 증가시키지 않는다.
  기존에 생성된 변수를  재사용한다.


*/

//sigma(n)을 꼬리 재귀호출로 구현하기

"use strict"
function sigma(n, sum) {
  if( n == 1)
    return sum + n;
  return sigma(n -1, sum + n)
}

var result = sigma(5, 0)
console.log(result)