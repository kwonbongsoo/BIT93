/* 주제:  배열
- 여러 개의 메모리를 같은 이름의 변수로 선언할 때 사용한다
  여러 개의 값을 다루기 편하다. 특히 반복문을 사용해 값을 다루기
  편하다.
- var names = [];

*/
"use strict"
//배열 사용 전
var kor = 100,eng = 100, math = 100;
var sum = kor + eng + math;
var aver = sum / 3;
console.log(kor,eng,math,sum,aver);
//배열사용후
var score = [90,80,70];
score[3] = score[0] + score[1] + score[2];
score[4] = score[3] / 3;

console.log(score[0],score[1],score[2],score[3],score[4]);
