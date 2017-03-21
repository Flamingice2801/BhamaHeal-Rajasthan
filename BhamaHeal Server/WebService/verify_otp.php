<?php
$mobile=$_GET['mobile'];
$otp=$_GET['otp'];

$host="localhost";
$uname="root";
$pass="root";
$DB_NAME="BhamaHeal";

$conn=new mysqli($host,$uname,$pass,$DB_NAME);

$query="SELECT * FROM otp_table where number=".$mobile." and otp=".$otp;

$result=$conn->query($query);

$row=$result->fetch_assoc();
if($row['id']==null){
    echo 0;
}
else echo 1;
?>