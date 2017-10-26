var back = document.querySelector('#back')
var printNum = document.querySelector('#printNum')
var list = []
var unique = 0
j = 0;

back.onclick =  function() {
  if(list.length) {
    list.length -= 1
    printNum.innerHTML = ""
    for (var i = 0; i < list.length;i++)
      printNum.innerHTML+= list[i]
  }
}
function oper(value) {
  if(unique == 2) {
    list[list.length-1] = value
    printNum.innerHTML = ""
    for (var i = 0; i < list.length;i++)
      printNum.innerHTML+= list[i]
    return
  }else if(unique == 4)
    return
    list.push(value)
  printNum.innerHTML += value
  unique = 2
  if(j == 1)
   j = 2
}
function num(value) {
  if(unique == 0 || unique == 3)
    printNum.innerHTML = ""
  list.push(value)
  printNum.innerHTML += value
  unique = 1
  if(j == 2)
   j = 0
}
function calc() {
  printNum.innerHTML = eval(printNum.innerHTML)
  list.length = 0
  list.push(printNum.innerHTML)
  unique = 3
  }
function clearcal() {
  printNum.innerHTML = "";
  list.length = 0
  unique = 0
  j = 0
}
function jum(value) {
  if(unique == 0) {
    printNum.innerHTML = "좋은말로할때 입력다시하세요"
  } else if (unique == 2 ||unique == 4 || j == 1 || j == 2)
    return
  printNum.innerHTML += value
  list.push(value)
  unique = 4
  j = 1;
}
