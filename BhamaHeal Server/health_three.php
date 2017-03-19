<?php
$bsid=$_GET['bhamashah'];
$aadhar=$_GET['aadhar'];
$remark=$_GET['remark'];
$type=$_GET['type'];

$host="localhost";
$uname="root";
$pass="root";
$DB_NAME="BhamaHeal";

$conn=new mysqli($host,$uname,$pass,$DB_NAME);

$query="INSERT INTO TABLE reports(bhamashah,aadhar,remark,type) VALUES(\"".$bsid."\",\"".$aadhar."\",\"".$remark."\",\"".$type."\")";

echo $query;
// $conn->query(query);

?>