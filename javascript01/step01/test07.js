"use strict"
var name;
console.log(typeof name);

name = "홍길동";
console.log(typeof name);
name = 10;
console.log(typeof name);
name = 3.14;
console.log(typeof name);

name = true;
console.log(typeof name);

name = new Object();
console.log(typeof name);

name = [];
console.log(typeof name);
name = function(){};
console.log(typeof name);
name = null;
console.log(typeof name);

name = undefined; //다시선언시켜라
console.log(typeof name);

name = NaN;
console.log(typeof name);
