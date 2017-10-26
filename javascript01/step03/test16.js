/* 주제: 흐름 제어문 -반복문 for.. of
- 배열 뿐만 아니라 객체의 프로퍼티를 추추랄 때 사용한다
- for .. in과 차이점은 변수에 저장되는 것은 인덱스나 프로퍼티명이 아니라
 값이라는 점이다.
for(var value of 배열 또는 객체)
   명령문;

   for(var value of 배열 또는 객체){
      명령문;
 }
*/
"use strict"
var names = ["홍길동","임꺽정","유관순","안중근","윤봉길","김구"];

for(var index in names) //index 를 표시
//배열의 특정범위만 반복할수 없다. 무조건 전체 반복이다.
   console.log(index);
   //배열인 경우 변수 key에 인덱스가 저장된다.
  console.log("---------------------------------");
  for(var value of names)//안에 값을 표시
     console.log(value);
    console.log("---------------------------------");

//그러나 for ..of 에서도 객체를 다룰 수 있다.(iterable객체만 다룰수있음)
//- 객체는 값을 저장할 때 숫자 인덱스 대신, 문자로된 key를 사용하여 저장
var student = {
  name:"홍길동",
  age:20,
  tel:"1111-1111",
  email:"test@test.com"
};

for(var a in student){
  console.log(a);
}
console.log("---------------------------------");
// for(var a of student){
//   console.log(a);
// }
// console.log("---------------------------------");
