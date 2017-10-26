/* 주제: 객체 -  this 변수를 통해 객체를 초기화시키기
-  this는 빈객체 주소를 저장하고 있다.
*/
"use strict"

function init() {
    //계산기로서 역활을 할 수 있도록 객체를 초기화시켜보자!
    console.log(this)
    this.result = 0; //빈 객체에 result 이름으로 0 값을 저장한다.
                     // 만약 이미 result라는 이름으로 저장된 값이 있다면,
                     // 그 값을 덮어쓴다
    this.plus = function(value) { this.result += value }
    this.minus = function(value) { this.result -= value }
    this.multiple = function(value) { this.result *= value }
    this.divide = function(value) { this.result /= value }
}

var calc = new init()
//new 다음에 곧바로 호출하기 호출이 끝나면 그 자리에 객체주소가
//놓인다

console.log(calc)

calc.plus(10)
calc.plus(20)
calc.multiple(3)
calc.minus(7)
calc.divide(2) // 41.5

console.log(calc.result)

var calc2 = {
  result: 0,
  plus:function(value) { this.result += value },
  minus:function(value) { this.result -= value },
  multiple:function(value) { this.result *= value },
  divide:function(value) { this.result /= value }
}

console.log(calc2)
calc2.plus(10)
calc2.plus(20)
calc2.multiple(3)
calc2.minus(7)
calc2.divide(2)



console.log("----------------------------")

//객체를 한개만 만들어서 사용할 경우, {} 사용하여 객체를 생성하는것이 편함
// 같은 객체를 여러 개 를 만들경우,{} 보다 생성자 사용하는게 더 훨씬 편함
// 코드가 간결해짐
