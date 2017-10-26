/* 주제: 객체 값 초기화 시키기
    - 문법
      var 변수명 = {프로퍼티명: 값, 프로퍼티명: 값 프로퍼티명: 값...}

*/
"use strict"
// 배열초기화


var names = ["홍길동", "임꺽정", "유관순"]
//이렇게 배열은 빈배열로 초기화 시켜야 사용가능하다.

names[5] = "윤봉길"
console.log(names)
console.log("----------------------------------------------")

//객체? 문자열 붙여 값을 저장

var obj = {"name": "홍길동", "name2": "임꺽정", "name3": "유관순"}
obj.name4 = "안중근";


console.log(obj)

console.log(typeof(names))
console.log(typeof(obj))

var obj2 = {name: "홍길동", name2: "임꺽정", name3: "유관순"}
console.log(obj2)
//프로퍼티 이름에는 공백이나 특수문자가 없다면 ""나 ''를 안써도된다.
