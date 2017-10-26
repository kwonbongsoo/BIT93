<?php
try{
         $conn=new pdo('mysql:host=localhost','suna','1111');
        }catch(PDOException $e){
            echo 'could not connect:'.$e->getMessage();
        }
         $selDb=$conn->exec('use answerofgod');
          if(!$selDb){
                 $createDB=$conn->exec('create database answerofgod');
              $useDB=$conn->exec('use answerofgod');
              $conn->exec('create table user(
                                id int not null auto_increment,
                                user text not null,
                                pw text not null,
                                constraint pk primary key(id)
                                )');
              }
?>
