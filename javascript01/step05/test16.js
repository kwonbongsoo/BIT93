
/* 주제: 객체 - 일반 함수와 인스턴스 함수
- 일반함수
  => 객체에 들어있는 값에 의존하지 않고 실행하는 함수
- 인스턴스 함수
  => "객체"를 다른 말로 "인스턴스"라고 부른다.
     "사람"과 "청소년"의 관계와 같다.
     즉 "객체"는 일반적인 값, 배열, 함수 등을 가리키는 일반 용어이고,
     "인스턴스"는 new 명령 또는 {}을 통해 생성된 객체를 가리키는 용어이다.
  => 인스턴스에 들어있는 값을 다루는 함수
  => 인스턴스 없이 호출 할수 없다.
*/
"use strict"

function Calculator() {
  this.result = 0
}

//프로토타입은 인스턴스를 다루기 위함 으로 존재
Calculator.prototype.plus = function(value) {this.result += value} //인스턴스 함수
Calculator.prototype.plus2 = function(a, b) {return a + b} //인스턴스 함수
var c1 = new Calculator()

c1.plus(100)
console.log(c1.result)
var r1 = c1.plus2(100, 200) //두 개의 아규먼트 값을 더해서 그 결과를 리턴

console.log(r1)

//plus() 함수는 실행할 때 인스턴스의 변수를 사용한다.
//따라서 plus() 함수는 prototype 객체에 보관하는 것이 맞다.
// 왜? prototype에는 인스턴스에 대해서 작업을 수행하는 함수를 두는 장소이기 때문이다

/*
  plus2() 함수는 실행할 떄 인스턴스를 사용하지 않는다.
  내부 코드를 보면 this 변수를 사용하지 않는다는 것을 알 수 있다.
  이런 함수는 굳이 prototype에 저장할 필요는 없다.


*/

// 어떻게 해야 하는가?
// 선택1) 함수를 글로벌로 함수로 만든다.
function plus2(a, b){
  return a + b
}

//선택2) 인스턴스를 사용하지 않는 함수를 무조건 글로벌 함수로 만든다면,
//       함수를 만들다가 기존 함수를 덮어 쓰는 경우도 발생하게 될 것이다.
//       이런 문제를 해결하기 위해 함수들을 적당하게 분류할 필요가 있다.
//       힌트! "함수도 객체다!"

Calculator.plus2 = function(a, b) {return a + b}

//함수도 객체라서 값을 마음껏 저장할 수 있다.
// 그러나 함수라서 일반 객체처럼 값을 저장하는 용도로 구분없이 사용하지는 않는다.
// 그러면서 함수의 이름을 보면 어떤 역할을 하는지 일종의 그룹명으로 생각할 수 있다
// 이런 점을 이용하여 "함수 객체"에 그 함수 이름에 맞는 유사한 기능들을
// 저장하게 된다.

//함수 객체의 또 다른 활용법으로 위와 같이 그 함수의 이름과 어울리는,
//그 함수의 역할에 맞는 기능을 보관할 때 사용한다.
