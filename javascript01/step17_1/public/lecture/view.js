"use strict"

var viewTags = $('.bit-view'),
    newTags = $('.bit-new'),
    fiNo = $('#fi-no'),
    fiTitl = $('#fi-titl'),
    fiDscp = $('#fi-dscp'),
    fiSdt2 = $('#fi-sdt2'),
    fiEdt2 = $('#fi-edt2'),
    fiQty = $('#fi-qty'),
    fiPric = $('#fi-pric'),
    fiThrs = $('#fi-thrs'),
    fiMrno = $('#fi-mrno'),
    fiCrmno = $('#fi-crmno')

var no = 0

try {
  no = location.href.split('?')[1].split('=')[1]
} catch (err) {

}

if (no == 0) { //새강의 등록
  viewTags.css('display', 'none')
  addSelect() //매니저 강의실 옵션 셀렉트 추가함수
  $('#add-btn').click(() => {
    $.post('add.json', lectureAddUpdateObj(), (result) => {
      alert('추가 되었습니다 ㄱㅇㄷ')
      location.href = 'index.html'
    }, 'json')
  })

}else { //강의 정보 조회
  newTags.css('display', 'none')
  addSelect() //매니저 강의실 옵션 셀렉트 추가함수

  $.getJSON('detail.json', {'no': no}, (result) => { //선택된 강의 상세보기

    fiNo.text(no)
    fiTitl.val(result.titl)
    fiDscp.val(result.dscp)
    fiSdt2.val(result.sdt2)
    fiEdt2.val(result.edt2)
    fiQty.val(result.qty)
    fiThrs.val(result.thrs)
    fiPric.val(result.pric)
    $('#fi-mrno option[value="'+result.mrno+'"]').prop('selected', true)
    //선택된 강의 매니저 selected 하기
    $('#fi-crmno option[value="'+result.crmno+'"]').prop('selected', true)
    //선택된 강의 강의실 selected 하기
  })

  $('#del-btn').click(() => {
    $.getJSON('delete.json', {'no' : no}, (result) => {
      alert('삭제함 개이덕')
      location.href = 'index.html'
    })
  })

  $('#upd-btn').click(() => {
    $.post('update.json', lectureAddUpdateObj(), (result) => {
      alert('변경 되었습니다 ㄱㅇㄷ')
      location.href = 'index.html'
    }, 'json')
  })
}//else

function addSelect() {
  $.getJSON('select.json', (result) => { //셀렉트 옵션 추가.
    var templateFn = Handlebars.compile($('#tbody-managers').text())
    $(templateFn(result)).appendTo(fiMrno)

    templateFn = Handlebars.compile($('#tbody-classrooms').text())
    $(templateFn(result)).appendTo(fiCrmno)
  })
}
function lectureAddUpdateObj() { // 추가나 업데이트시 쓸 객체함수
  return {
    'titl' : fiTitl.val(),
    'dscp' : fiDscp.val(),
    'sdt2' : fiSdt2.val(),
    'edt2' : fiEdt2.val(),
    'qty' : fiQty.val(),
    'thrs' : fiThrs.val(),
    'pric' : fiPric.val(),
    'crmno' : fiCrmno.val(),
    'mrno' : fiMrno.val(),
    'no' : fiNo.text()
  }
}
