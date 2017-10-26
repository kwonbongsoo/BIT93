/* 주제: 흐름 제어문 -반복문 for.. in
- 배열 뿐만 아니라 객체의 프로퍼티를 추추랄 때 사용한다
- 문법
for(var key in 배열 또는 객체)
   명령문;

   for(var key in 배열 또는 객체){
      명령문;
 }
*/
"use strict"
var names = ["홍길동","임꺽정","유관순","안중근","윤봉길","김구"];

for(var key in names)
//배열의 특정범위만 반복할수 없다. 무조건 전체 반복이다.
   console.log(key,names[key]);
   //배열인 경우 변수 key에 인덱스가 저장된다.
  console.log("---------------------------------");
//다음 for문은 index를 직접 다룰 수 있다. 그러나 for..in은 불가능하다
for(var i = 0; i<names.length;i += 2)
  console.log(i, names[i]);
console.log("---------------------------------");

//그러나 for ..in 은 객체를 다룰 수 있다.
//- 객체는 값을 저장할 때 숫자 인덱스 대신, 문자로된 key를 사용하여 저장
var student = {
  name:"홍길동",
  age:20,
  tel:"1111-1111",
  email:"test@test.com"
};

for(var key in student){
  console.log(key,student[key]);
}
console.log("---------------------------------");
