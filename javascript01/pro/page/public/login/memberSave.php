<html>
   <meta charset="utf-8">
<?php
$host = 'localhost';
$user = 'suna';
$pw = '1111';
$database = 'pro';
$mysql = new mysql($host, $user, $pw, $database);

 $id=$_POST['id'];
 $password=($_POST['pwd']);
 $name=$_POST['name'];
 $major=$_POST['major'];


 $sql = "insert into member (id, pwd, name, major)";
 $sql = $sql."values('$id','$password','$name','$major')";
 if($mysql->query($sql)){
  echo 'success inserting <p/>';
  echo $name.'님 가입 되셨습니다.<p/>';
 }else{
  echo 'fail to insert sql';
 }
mysqli_close($mysqli);
?>

<input type="button" value="로그인하러가기" onclick="location='index.php'">
</html>
