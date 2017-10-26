/* 주제: 객체 - 변수에 저장하는 것은 객체의 주소이다.
- 어떤 메모리에 주소를 저장하는 변수를 "레퍼런스(변수)"라 부른다.
- 문법

*/
"use strict"
// names에 배열이 저장되는가? 아니면 배열의 주소가 저장되는가?



var names1 = ["홍길동", "임꺽정", "유관순"]
var names2 = names1;

names1[5] = "윤봉길"
console.log(names1)
console.log(names2)
console.log("----------------------------------------------")



var obj1 = {"name": "홍길동", "name2": "임꺽정", "name3": "유관순"}
obj1.name4 = "안중근";

var obj2 = obj1
obj2.name = "오호라"
console.log(obj1)
console.log(obj2)

//참고!
//숫자인 경우
var v1 = 100
var v2 = v1
v1 = 200
console.log(v1,v2)

v1 = true
v2 = v1
v1 = false

v1 = "홍길동"
v2 = v1
//v1 = "임꺽정"

var v3 = v1.replace ('동', '순')
console.log(v1, v2)

v1 = "홍길동"
v2 = v1.replace("동", "순")// 문자열은 immutable객체 이기 때문에 값을 바꿀수없다
//그럼 replace()는 무엇을 바꾼 것인가?
//원본 문자열에서 "동"문자를 "순"문자로 바꾼 새 문자열을 만든다
//그리고 새로 만든 문자열을 리턴한다.

console.log(v1, v2)
//문자열을 number나 boolean 값 처럼 직접 변수에 저장한다면
// 다른 변수에 값을 저장할 때 똑 같은 문자열이 계속 복제 될것이다.
//메모리를 낭비하게 된다.
v1 = "오호라... 그렇군요 이렇게 긴 문자열을 값으로 다룬다면 문제가 됨"
v2 = v1
console.log(v1)
console.log(v2)
