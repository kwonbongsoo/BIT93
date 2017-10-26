"use strict"


var fiNo = $('#fi-no'),
    fiEmail = $('#fi-email'),
    fiName = $('#fi-name'),
    fiTel = $('#fi-tel'),
    fiPosi = $('#fi-posi'),
    fiFax = $('#fi-fax'),
    fiPath = $('#fi-path'),
    viewTags = $('.bit-view'),
    newTags = $('.bit-new')

var no = 0

try {
  no = location.href.split('?')[1].split('=')[1]
} catch (err) {

}

if (no == 0) {
  viewTags.css('display', 'none')
  $('#add-btn').click(() => {
    $.post('add.json', managerAddUpdateObj(), (result) => {
      alert('추가함 ㄱㅇㄷ')
      location.href = 'index.html'
    }, 'json')
  })
} else { //학생 정보조회
  newTags.css('display', 'none')
  $.getJSON('detail.json', {'no' : no}, result => {
    fiNo.text(result.mno)
    fiEmail.val(result.email)
    fiName.val(result.name)
    fiTel.val(result.tel)
    fiPosi.val(result.posi)
    fiFax.val(result.fax)
    fiPath.val(result.path)
  })

  $('#del-btn').click(() => {
    $.getJSON('delete.json', {'no' : no},  (result) => {
      alert('삭제함 개이득')
      location.href = 'index.html'
    })
  })

  $('#upd-btn').click(() => {
    $.post('update.json', managerAddUpdateObj(), (result) => {
      alert('변경 성공 개이득')
      location.href = 'index.html'
    }, 'json')
  })
} // else

function managerAddUpdateObj() { //매니저 추가 업데이트 객체
  return {
    'no' : fiNo.text(),
    'email' : fiEmail.val(),
    'name' : fiName.val(),
    'tel' : fiTel.val(),
    'posi' : fiPosi.val(),
    'fax' : fiFax.val(),
    'path' : fiPath.val()
  }
}
