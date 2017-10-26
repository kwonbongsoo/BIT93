"use strict"

var fiNo = $('#fi-no'),
    fiEmail = $('#fi-email'),
    fiName = $('#fi-name'),
    fiTel = $('#fi-tel'),
    fiHmpg= $('#fi-hmpg'),
    fiFcbk = $('#fi-fcbk'),
    fiTwit = $('#fi-twit'),
    viewTags = $('.bit-view'),
    newTags = $('.bit-new')

var no = 0

try {
   no = location.href.split('?')[1].substring(3)
   console.log(no)
} catch (err) {

}
if (no == 0) {
  viewTags.css('display', 'none')
  $('#add-btn').click(() => {
    $.post('add.json', teacherAddUpdateObj(), (result) => {
      alert('추가 됨 개이덕')
      location.href = 'index.html'
    }, 'json')
  })
} else {
  newTags.css('display', 'none')
  $.getJSON('detail.json', {'no' : no}, (result) => {
    fiNo.text(no)
    fiEmail.val(result.email)
    fiName.val(result.name)
    fiTel.val(result.tel)
    fiHmpg.val(result.hmpg)
    fiFcbk.val(result.fcbk)
    fiTwit.val(result.twit)

  })

  $('#del-btn').click(() => {
    $.getJSON('delete.json', {'no' : no}, (result) => {
      location.href = 'index.html'
    })
  })

  $('#upd-btn').click(() => {
    $.post('update.json', teacherAddUpdateObj(), (result) => {
      alert('변경 성공 개이득')
      location.href = 'index.html'
    } , 'json') //json 형식이라고 안줘도 가능하다
  })
}//else

function teacherAddUpdateObj() { //강사 추가 변경 객체 함수
  return {
    'no' : no,
    'email' : fiEmail.val(),
    'name' : fiName.val(),
    'tel' : fiTel.val(),
    'hmpg' : fiHmpg.val(),
    'fcbk' : fiFcbk.val(),
    'twit' : fiTwit.val()
  }
}
