/* 주제: 연산자 - null, undefined, NaN, Infinity, -Infinity 값 비교
-

*/
"use strict"

var v1 = undefined;//변수는 존재하는데 값을 지정하지 않아 타입이 정의 안됨
//x처럼 존재하지 않는 변수이기 때문에 비교 연산자를 사용할 수는 없다.
// if(x == undefined)console.log("v0는 undefined");
var v0;
    v1 = 20;
    v1 = undefined;//존재하는 변수를 undefined로 만들 수 있다.
//undefined, 변수는 존재하지만 값을 지정하지 않는 경우!
if(v0 == undefined) console.log("v0는 undefined");
//v0는 변수는 존재 하지만 값이 없는 상태이다.
if(v1 == undefined) console.log("v1는 undefined");
//if문 조건식은 반드시 boolean 값이어야한다. 만약 boolean값이 아니라면
//암시적 형변환이 자동으로 수행된다.
//v1 변수는 undefined 이다 . undefined는 암시적 형변환을 통해 false로 바뀐다
if(v1) console.log("v1는 ?");

var v2 = null; // v2는 특정 객체를 가리키지 않음을 지정할 때 null사용
if(v2 == null) console.log("v2는 null");
//v2 는 null을 넣음으로서 그 변수는 객체를 넣기위함이라고 볼수 있다.

var v3 = NaN;//v3는 number 타입이다. 값은 숫자가 아닌 상태를 가르킨다.
console.log("v3의 타입 = ",typeof v3);
//NaN의 상태를 알고 싶을때 다음과 같이 직접 비교할 수 없다.
if(v3 == NaN) console.log("v3는 NaN");
//해결책? NaN 상태를 알고 싶다면, 특별한 함수를 사용해야함
if(isNaN(v3)) console.log("v3는 isNaN(v3)==true");

var v4 = Infinity;

if(v4 == Infinity) console.log("v4는 Infinity");//직접 비교가능
