var viewTags = $('.bit-view'),
    newTags = $('.bit-new'),
    fiNo = $('#fi-no'),
    fiTitle = $('#fi-title'),
    fiEmail = $('#fi-email'),
    fiContent = $('#fi-content'),
    fiStartDate = $('#fi-start-date'),
    fiEndDate = $('#fi-end-date'),
    fiQuantity = $('#fi-quantity'),
    fiPrice = $('#fi-price'),
    fiPlace = $('#fi-place')

    var lat=33.450701,lng=126.570667


var no = 0
try {
  no = location.href.split('?')[1].split('=')[1]
} catch (err) {}

if (no == 0) { // 새 강의 등록
  //강의  실 및 매니저 목록 가져오기
  thisLocaition()
  viewTags.css('display', 'none')

  $('#add-btn').click(function() {
    $.post('add.json', {
      'title': fiTitle.val(),
      'email' : fiEmail.val(),
      'content': fiContent.val(),
      'startDate': fiStartDate.val(),
      'endDate': fiEndDate.val(),
      'quantity': fiQuantity.val(),
      'price': fiPrice.val(),
      'place': fiPlace.val(),
      'lat' : lat,
      'lng' : lng
    }, function(result) {
      location.href = 'study.html'
    }, 'json')
  })
  num = 0
} else { // 강의 정보 조회
  newTags.css('display', 'none')


	$.getJSON('detail.json', {'no': no}, function(result) {
		fiNo.text(result.sno)
		fiTitle.val(result.title)
    fiEmail.val(result.email)
		fiContent.val(result.dscp)
		fiStartDate.val(result.sdt2)
		fiEndDate.val(result.edt2)
		fiQuantity.val(result.many)
		fiPrice.val(result.price)
	  fiPlace.val(result.place)
    lat = result.lat
    lng = result.lng
    mapLoading()
	})



  $('#upd-btn').click(function() {
    $.post('update.json', {
    	'no': fiNo.text(),
      'email': fiEmail.val(),
        'title': fiTitle.val(),
        'content': fiContent.val(),
        'startDate': fiStartDate.val(),
        'endDate': fiEndDate.val(),
        'quantity': fiQuantity.val(),
        'price': fiPrice.val(),
        'place': fiPlace.val(),
        'lat' : lat,
        'lng' : lng

    }, function(result) {
      location.href = 'study.html'
    }, 'json')
  })

  $('#del-btn').click(function() {
    $.getJSON('delete.json', {'no': no}, function(result) {
      location.href = 'study.html'
    })
  })
}

 function mapLoading() {
   var mapContainer = document.getElementById('map'), // 지도를 표시할 div
       mapOption = {
           center: new daum.maps.LatLng(lat, lng), // 지도의 중심좌표
           level: 3 // 지도의 확대 레벨
       };

   var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
   var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커이미지의 주소입니다
    imageSize = new daum.maps.Size(64, 69), // 마커이미지의 크기입니다
    imageOption = {offset: new daum.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
    var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커이미지의 주소입니다
        imageSize = new daum.maps.Size(64, 69), // 마커이미지의 크기입니다
        imageOprion = {offset: new daum.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

    // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
    var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imageOprion),
        markerPosition = new daum.maps.LatLng(lat, lng); // 마커가 표시될 위치입니다

    // 마커를 생성합니다
    var marker = new daum.maps.Marker({
      position: markerPosition,
      image: markerImage // 마커이미지 설정
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);

    // 커스텀 오버레이에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    var content = '<div class="customoverlay">' +
        '  <a target="_blank">' +
        '    <span class="title">'+fiPlace.val()+'</span>' +
        '  </a>' +
        '</div>';

    // 커스텀 오버레이가 표시될 위치입니다
    var position = new daum.maps.LatLng(lat+0.00075, lng);

    // 커스텀 오버레이를 생성합니다
    var customOverlay = new daum.maps.CustomOverlay({
        map: map,
        position: position,
        content: content,
        yAnchor: 1
    });
   // 지도에 클릭 이벤트를 등록합니다
   // 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
   daum.maps.event.addListener(map, 'click', function(mouseEvent) {

       // 클릭한 위도, 경도 정보를 가져옵니다
       var latlng = mouseEvent.latLng;

       // 마커 위치를 클릭한 위치로 옮깁니다
       marker.setPosition(latlng);
       lat = latlng.getLat()
       lng = latlng.getLng()

       // 커스텀 오버레이에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다

       $('.customoverlay').remove();
       var content = '<div class="customoverlay">' +
           '  <a target="_blank">' +
           '    <span class="title">'+fiPlace.val()+'</span>' +
           '  </a>' +
           '</div>';

       // 커스텀 오버레이가 표시될 위치입니다
       var position = new daum.maps.LatLng(lat+0.00075, lng);

       // 커스텀 오버레이를 생성합니다
       var customOverlay = new daum.maps.CustomOverlay({
           map: map,
           position: position,
           content: content,
           yAnchor: 1
       });
   });

 }
 function thisLocaition() {
   var mapContainer = document.getElementById('map'), // 지도를 표시할 div
       mapOption = {
           center: new daum.maps.LatLng(lat, lng), // 지도의 중심좌표
           level: 3 // 지도의 확대 레벨
       };

   var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
   // HTML5의 geolocation으로 사용할 수 있는지 확인합니다
   if (navigator.geolocation) {

       // GeoLocation을 이용해서 접속 위치를 얻어옵니다
       navigator.geolocation.getCurrentPosition(function(position) {

               lat = position.coords.latitude // 위도
               lon = position.coords.longitude // 경도

           var locPosition = new daum.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
               message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다

           // 마커와 인포윈도우를 표시합니다
           displayMarker(locPosition, message);

         });

   } else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다

       var locPosition = new daum.maps.LatLng(33.450701, 126.570667),
           message = 'geolocation을 사용할수 없어요..'

       displayMarker(locPosition, message);
   }

   // 지도에 마커와 인포윈도우를 표시하는 함수입니다
   function displayMarker(locPosition, message) {

       // 마커를 생성합니다
       var marker = new daum.maps.Marker({
           map: map,
           position: locPosition
       });

       var iwContent = message, // 인포윈도우에 표시할 내용
           iwRemoveable = true;

       // 인포윈도우를 생성합니다
       var infowindow = new daum.maps.InfoWindow({
           content : iwContent,
           removable : iwRemoveable
       });

       // 인포윈도우를 마커위에 표시합니다
       infowindow.open(map, marker);

       // 지도 중심좌표를 접속위치로 변경합니다
       map.setCenter(locPosition);
   }

   var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커이미지의 주소입니다
    imageSize = new daum.maps.Size(64, 69), // 마커이미지의 크기입니다
    imageOption = {offset: new daum.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new daum.maps.LatLng(lat, 127.09598); // 마커가 표시될 위치입니다
   // 지도를 클릭한 위치에 표출할 마커입니다
   var marker = new daum.maps.Marker({
       // 지도 중심좌표에 마커를 생성합니다
       position: map.getCenter(),
       image: markerImage
   });
   // 지도에 마커를 표시합니다
   marker.setMap(map);

   // 지도에 클릭 이벤트를 등록합니다
   // 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
   daum.maps.event.addListener(map, 'click', function(mouseEvent) {

       // 클릭한 위도, 경도 정보를 가져옵니다
       var latlng = mouseEvent.latLng;

       // 마커 위치를 클릭한 위치로 옮깁니다
       marker.setPosition(latlng);
       lat = latlng.getLat()
       lng = latlng.getLng()
   });

 }
