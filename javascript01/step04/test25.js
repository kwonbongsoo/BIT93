/* 주제:함수 -클로저(closere)


*/
"use strict"
var arr = ['홍길동', '임꺽정', '유관순', '안중근', '윤봉길']
var functionList =[]

// let 변수는 선언된 범위 안에서만 유효하다.
// 즉 그 범위를 벗어나면 로컬 변수처럼 제거된다.
// 그래서 let 변수도 클로저의 복제 대상이다
  var count = -1;
  //블록{} 안에 선언하는 var 변수는 "글로벌 변수"이다.
  //단, 함수 안에 선언된 var 변수는 "로컬 변수"이다
  for (let i = 0; i < arr.length; i++){
      functionList[i] = function() {
        console.log(arr[i]); //변수 i는 let 변수이기 때문에 로컬 변수 처럼 따로 복제
      }
  }
 //console.log(i) //i응 let 변수이기 떄문에 for문이 끝나면 제거 된다.
 functionList[0]()
 functionList[1]()
 functionList[2]()
 functionList[3]()
 functionList[4]()

 /* 함수를 만들 때 그 함수가 사용한 변수가
 로컬 변수나 let 변수일 경우, 언제 제거 될지 모르기때문에 실행안전을 위해
 따로 복제해 둔다.
 그리고 그 복제된 변수를 사용한다.
 */
