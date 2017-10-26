"use strict"
var pageNoTag = $('#page-no'),
    tbody = $('#teacher-tbl > tbody'),
    prevBtn = $('#prev-btn'),
    nextBtn = $('#next-btn'),
    pageSize = 4;

var currPageNo = parseInt(pageNoTag.text())

displayList(1)


function displayList(pageNo) {
  $.getJSON('list.json', {'pageNo' : pageNo, 'pageSize' : pageSize}, (result) => {
    var list = result.list
    var totalCount = result.totalCount
    var lastPageNo = parseInt(totalCount / pageSize) + (totalCount % pageSize > 0 ? 1 : 0)

    tbody.text('')
    for (var s of list) {
      $('<tr>').append($('<td>').text(s.mno))
      .append($('<td>').append(
        $('<a>').attr('href', 'view.html?no=' + s.mno)
                .text(s.name == '' ? '이름없음' : s.name)))
      .append($('<td>').text(s.tel))
      .append($('<td>').text(s.email))
      .append($('<td>').text(s.hmpg))
      .appendTo(tbody)
    }

    currPageNo = pageNo
    pageNoTag.text(currPageNo)

    if (currPageNo == 1)
      prevBtn.prop('disabled', true)
    else
      prevBtn.prop('disabled', false)

    if(currPageNo == lastPageNo)
      nextBtn.prop('disabled', true)
    else
      nextBtn.prop('disabled', false)
  })
} // displayList()


prevBtn.click(() => {
  displayList(currPageNo - 1)
})
nextBtn.click(() => {
  displayList(currPageNo + 1)
})
