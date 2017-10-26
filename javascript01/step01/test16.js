/* 주제:  배열
*/
"use strict"
//
var a1 = [];//빈배열
console.log(a1.length);
//배열 초기화하는법ㅂ
var a2 = [10,20,30,40];
console.log(a2.length);

//배열에 값을 추가하기

console.log("------------------");

a1[0]=100;
a1[1]=200;
console.log(a1.length);
//중간 인덱스를 건너뛰고 값을 넣으면 가장 큰 인덱스 만큼
//배열크기가 결정된다
a1[100] =300;
console.log(a1.length);
console.log("------------------");
console.log(a1[0]);
console.log(a1[1]);
console.log(a1[2]);
console.log(a1[101]);

//배열에 다른 종류의 값을 섞어 넣기
a2[4] = "홍길동";
a2[5] = false;
a2[6] = function(){};
a2[7] = null;
a2[8] = {};

for(var i=0;i<a2.length;i++)
  console.log(i,":",a2[i]);
