/* 주제:  let 변수의 중복선언
- 중복선언 할수 없다.

*/
"use strict"
var name = "홍길동";
var name = "임꺽정";
console.log(name);

let name2 = "홍길동";
let name2 = "임꺽정";//오류!
console.log(name2);
