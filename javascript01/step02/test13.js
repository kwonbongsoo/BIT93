/* 주제:연산자 - 연산자 우선 순위
   - 한 식(expression) 안에 여러 개의 연산자가 사용될 떄,
   - 연산자 우선순위에 따라 실행하는 순서가 결정된다.
   - 우선순위
   1 ()
   2 x++, x
   3 !x(논리), ~x,(비트),++x,--x
   4 **
   5 *, /, %
   6 +, -
   마지막 할당연산자
*/
"use strict"

var r;
r =10+2 *3;
console.log(r);
r = (10+2)*3;
console.log(r);
r=10/2*3;
console.log(r);

var a = 10;
r = a++ + a++ - a++;
console.log(r,a);
