"use strict"

var obj = {
  v1 : 100,
  v2() {
    console.log(this)
    return function () {
      console.log(this)
      console.log('bye')
    }
  }
}

var v3=obj.v2()
v3()

var obj1 = {}
obj1.x = obj.v2()
obj1.x()
console.log(obj1)
