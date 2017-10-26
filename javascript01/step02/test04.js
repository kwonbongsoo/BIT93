/* 주제: 연산자 - 증감 연산자
*/
"use strict"
var a;
a = 10;

console.log(++a);
console.log(--a);



console.log(a++);//a의 값을 변수 자리에 놓은다음에
// 변수의 값을 따로 1 증가함.

console.log(a);
a=10;
console.log(a--);
//a의 값 10을 그변수 자리에 놓은 다음에 변수의 값을 따로 1감소

a=10;
a=++a;
console.log(a);

a = 10;
a = a++;
console.log(a); //10이다.;
console.log("------------------");
a = 10;
var r = a++ + a++ + a++ + a--;
console.log(r);


/* "=" r-value를 모두 수행한 후 마지막으로 할당 연산을 수행

 */
