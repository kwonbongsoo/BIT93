
   var btn = document.getElementById("closeBtn");
   var createId = document.getElementById("signupBtn");
   var email = document.getElementById('email');
   var state = document.getElementById('state');
   var onlineBtn = document.getElementById('onlineBtn');
   var onlineBtn1 = document.getElementById('onlineBtn1');
   var onlineBtn2 = document.getElementById('onlineBtn2');
   var onlineBtn3 = document.getElementById('onlineBtn3');
   var onlineBtn4 = document.getElementById('onlineBtn4');
   var loginBtn = document.getElementById('loginBtn');
   var pwd = document.getElementById('pwd');
   var idList = [
     ["hong@test.com","ghdrlfehd"],
     ["star12310@naver.com", "qhdtn2108"]
   ];
   loginBtn.addEventListener('click', function() {
     if(email != undefined){
       for (var i = 0; i < idList.length; i++){
         for (var j = 0; j < idList[i].length; j++){
           if(email == idList[i][j] && pwd == idList[i][j]){
             swal("정보확인", "로그인 성공!", "success")
             return;
           }
         }
       }
     }else {
       sweetAlert("주의", "아이디를 입력해주세요!", "error");
     }
   })
   onlineBtn.addEventListener('click', function() {
     swal({
       title: "주의!",
       text: "준비중입니다!",
       type: "error",
       confirmButtonText: "닫기"
     });
   });
   onlineBtn1.addEventListener('click', function() {
     swal({
       title: "주의!",
       text: "준비중입니다!",
       type: "error",
       confirmButtonText: "닫기"
     });
   });
   onlineBtn2.addEventListener('click', function() {
     swal({
       title: "주의!",
       text: "준비중입니다!",
       type: "error",
       confirmButtonText: "닫기"
     });
   });
   onlineBtn3.addEventListener('click', function() {
     swal({
       title: "주의!",
       text: "준비중입니다!",
       type: "error",
       confirmButtonText: "닫기"
     });
   });
   onlineBtn4.addEventListener('click', function() {
     swal({
       title: "주의!",
       text: "준비중입니다!",
       type: "error",
       confirmButtonText: "닫기"
     });
   });
   btn.addEventListener('click', function (){
     var adDiv = document.getElementById("ad");
     adDiv.style.display = "none";
   });

   createId.addEventListener('click', function() {
     if(email.value == "hong@test.com") {
       sweetAlert("중복.", "아이디를 확인해주세요!", "error");
     }else {
       swal("축하합니다!", "가입되셨습니다!", "success")
     }
   });
