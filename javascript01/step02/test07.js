/* 주제:비트연산자
- 비트의 이동을 실행한다.
*/
"use strict"

//<<
//-왼쪾으로 1비트를 이동하면 변수의 값에 2를 곱한 효과
//-오른쪽 맨끝자리는 0으로 비운다
var a = 10;// 8비트면 (0000 1010)
console.log(a<<1)//a* 2**1 = 20;
console.log(a<<2)//a * 2**2 = 40;
console.log(a<<3)//a * 2**3 = 80;
console.log(a<<4)//a * 2**4 = 160;
//>>
//- 오른쪽으로 1비트를 이동하면 변수의 값을 2로 나누는 효과
//- 왼쪽 빈 자리는 부호비트로 채운다. 양수면 0,음수면 1로 채움
a = 175;
console.log(a>>1)// a / 2**1 = 87
console.log(a>>2)// a / 2**2 = 43
console.log(a>>3)// a / 2**3 = 21
console.log(a>>4)// a / 2**4 = 10

a=-65;
console.log(a>>1);

// >>>
// - 오른쪽으로 1비트를 이동하면 변수의 값을 2로 나누는 효과

a= 65;
console.log(a>>>1);
a=-65;
console.log(a>>>1);
