/* 주제: 암시적 형변환(implicit type casting(conversion))
 - 피연산자의 타입이 다르면 연산을 수행할수 없다.
   이런경우 자바스크립트 엔진은 내부에서 정한 규칙에 따라
   두 개의 값 중에서 한 개의 값을 다른 한개의 값과 동일한
   타입으로 자동변환한다.
   내부적으로 자동 변환하는 것을 암시적 형변환이라 한다
 - 규칙1)
  피연사 중에 number나 boolean 값이 있으면,
  나머지 하나를 number로 바꾼 다음에 연산을 수행한다.

*/
"use strict"

 console.log("7"==7);
 console.log("7"==8);
 console.log(true==7);
 console.log("0"==false); //-> 0==0
 console.log("1"==true); // -> 1==1
 console.log("hello"==true);// ->NaN ==1
 console.log("true"==true);// ->NaN ==1
 console.log("" == false);
 console.log("1111111111111")
 /*
 null, undefined,NaN는 그의미대로 비교한다
 - 즉 암시적 형변환을 하지 않는다.
 */
 console.log(false == null);
 console.log(false == undefined);
 console.log(false == NaN);
 console.log(false == 0);
 console.log(false == []);//빈배열은 0으로 바뀐다

 console.log("----------------------");

 //넘버와 불린을 비교할떈 불린을 숫자로 바꾼다


 console.log("0" ==null);
 //null의 의미는 변수가 비어있다.
 //undefined의 의미는 변수가 없다.
 console.log("0"==undefined);

 /* 규칙4)
  -

 */
