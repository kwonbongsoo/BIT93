/* 주제: 객체 - 소개
- 객체란? 문자열로 이름을 붙인 값들의 집합이다.
- 배열은 숫자로 이름을 붙인 값들의 집합이다.

*/
"use strict"
/* 참고
  소스파일 첫 명령어로 "use strict"를 선언하면
  자바스크립트 문법을 엄격하게 검사한다
  또는 node 실해할 때 다음과 같이 실행 아규먼트 "--use strict" 지정해도됨
  > node --use strict test01.js
  */

//배열 ? 숫자(인덱스)를 붙여 값을 저장한다.

var names = []
//이렇게 배열은 빈배열로 초기화 시켜야 사용가능하다.
names[0] = "홍길동"
names[1] = "임꺽정"
names[2] = "유관순"
names[5] = "윤봉길"
console.log(names)
console.log(names[0])
console.log(names[1])
console.log(names[2])
console.log(names[5])
console.log("----------------------------------------------")

//객체? 문자열 붙여 값을 저장

var obj = {}

obj["name"] = "홍길동"
obj['name2'] = '임꺽정'
obj.name3 = "유관순" //실무에서 많이씀

var v = "name4"
obj[v] = "윤봉길"
console.log(obj)
console.log(obj.name)
console.log(obj['name'])
console.log(obj["name"])
var v2 = 'name'
console.log(obj[v2])

// 객체에 저장하는 값을 보통 "프로퍼티(property)"라고 부른다
// 값을 저장할 때 사용하는 문자열을 "프로퍼티명"이라고 부른다.
// 프로퍼티 이름에특수문자나 공백이 등이 포함되어 있을 떄는
// "객체.프로퍼티명"으로 값을 저장할수 없다.
// obj.first name = "길동"//프로퍼티명에 공백이 있기때문에 이형식으로 사용안됨
obj['first name'] = '길동'//객체의 프로퍼티 이름에 공백이 있으면 안됨
console.log(obj['first name'])
//console.log(obj.first name) //안됨

obj['hello^^;'] = "오호라"
console.log(obj['hello^^;'])
