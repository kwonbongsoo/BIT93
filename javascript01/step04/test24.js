/* 주제:함수 -클로저(closere)


*/
"use strict"
var arr = ['홍길동', '임꺽정', '유관순', '안중근', '윤봉길']
var functionList =[]

  var count = -1;
  //블록{} 안에 선언하는 var 변수는 "글로벌 변수"이다.
  //단, 함수 안에 선언된 var 변수는 "로컬 변수"이다
  for (var i = 0; i < arr.length; i++){
      functionList[i] = function() {
        console.log(arr[i]);
      }
  }
 console.log(i)
 functionList[0]()
 functionList[1]()
 functionList[2]()
 functionList[3]()
 functionList[4]()
