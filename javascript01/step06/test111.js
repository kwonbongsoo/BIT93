"use strict"

var m1 = require('./test06_m1.js')

console.log(m1.plus(20, 10))
console.log(m1.multiple(13, 30))


var {multiple, divide} = require('./test07_m1.js')

console.log(multiple(20,30))
console.log(divide(300, 20))

var me = require('./test08_m1.js')

me()

m1 = require('./test09_m1.js')

me = m1()

me.plus(40)
me.minus(20)
me.multiple(10)
me.divide(10)

console.log(me.result)
