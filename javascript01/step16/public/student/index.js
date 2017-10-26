//서버에서 학생 목록 데이터를 받아 온다.
var pageNoTag = $('#page-no'),
    tbody = $('#student-tbl > tbody'),
    prevBtn = $('#prev-btn'),
    nextBtn = $('#next-btn'),
    pageSize = 4;

var currPageNo = parseInt(pageNoTag.text())

displayList(1)

function displayList(pageNo) {
  $.getJSON('list.json', {'pageNo': pageNo, 'pageSize': pageSize}, (result) => {
    // var obj = JSON.parse(result)// 서버에서 받은 문자열을 객체로 만드는 함수
    // console.log(obj) //'text'로 했을때...
    //문자열을 더하면 있는그대로 표현해준다.

    //json으로 했을때
    //json을 생략해도 가능하다
    // console.log(result)

    // 새로함
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
      .append($('<td>').text(s.work))
      .appendTo(tbody)
    }

    currPageNo = pageNo
    pageNoTag.text(currPageNo)

    if (currPageNo == 1) {
      prevBtn.prop('disabled', true)
    } else {
      prevBtn.prop('disabled', false)
    }

    if(currPageNo == lastPageNo) {
      nextBtn.prop('disabled', true)
    } else {
      nextBtn.prop('disabled', false)
    }
  })//'json')//'text')//비동기 요청이다 getJSON

} //displayList
//'json'을 생략해도되는경우는 Content-type을 명확하게 해줬을때만 생략이가능하다.
// 써주는게 더 좋은 방법이다. 받을때 콘텐트 타입을 잘못보낼수도 있기때문에
//getJSON은 타입을 JSON으로 자동 으로 변환해준다.

prevBtn.click(() => {
  displayList(currPageNo - 1)
})
nextBtn.click(() => {
  displayList(currPageNo + 1)
})
