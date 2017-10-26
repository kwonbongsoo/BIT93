/* 주제: 블록 변수 -let
- 변수가 선언된 블록 안에서만 사용 가능
- 문법
-let 글로벌 변수명
*/
"use strict"
var name = "홍길동";
{
  let name = "임꺽정";//이 블록에서만 사용할 변수
  console.log(name);
}
console.log(name);
{
  let age = 20;//이 블록에서만 사용가능. 블록이끝나면 사라짐.
  console.log(age);
}
console.log(age); //age 라는 변수는 없다. 실행오류!
