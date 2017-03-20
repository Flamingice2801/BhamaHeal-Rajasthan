<?php
error_reporting(E_ALL & ~E_NOTICE); ini_set('display_errors', '1');

$bsid=$_GET['bhamashah'];
$aadhar=$_GET['aadhar'];
$remark=$_GET['remark'];
$type=$_GET['type'];

$host="localhost";
$uname="root";
$pass="root";
$DB_NAME="BhamaHeal";

$conn=new mysqli($host,$uname,$pass,$DB_NAME);

$query="INSERT INTO reports(bhamashah,aadhar,remark,type) VALUES(\"".$bsid."\",\"".$aadhar."\",\"".$remark."\",\"".$type."\")";


$result=$conn->query($query);
echo $result;

?>