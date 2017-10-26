/* 주제: module 안에서 모듈 밖의 변수를 사용할 수 있는가?
*/
"use strict"


// 모듈을 로딩하는(가져다 쓰는) 쪽에서 선언한 v1 변수를 사용할 수 없다
//왜 ? NodeJS에서는 var로 선언한 변수는 모듈 변수로 취급한다.
// 즉 그 파일 안에서만 사용할 수 있다.
var v1 = 200//이 변수는 이 파일 안에서만 사용할 수 있다.
//v1 = 200 하면안됨
console.log('test10_m1.js => v1:', v1)
//global 객체는 모든 모듈이 공유하는 객체이다
//그래서 global 객체에 값을 저장하면 모든 객체가 사용할 수 있다.
global.v2 = 200
global.v3 = 300
console.log('test10_m1.js => global.v2:', global.v2)
//module.exports에 아무것도 저장하지 않으면
//그냥 빈 객체를 리턴할 것이다.
