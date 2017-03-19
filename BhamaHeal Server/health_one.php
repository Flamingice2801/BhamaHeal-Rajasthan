<?php
$aadhar=$_GET['aadhar'];
$cholestrol=$_GET['cholestrol'];
$blood=$_GET['blood'];
$hb=$_GET['hb'];
$rbc=$_GET['rbc'];
$platelets=$_GET['platelets'];

$host="localhost";
$uname="root";
$pass="root";
$DB_NAME="BhamaHeal";

$conn=new mysqli($host,$uname,$pass,$DB_NAME);

$query="INSERT INTO health_one(aadhar,cholestrol,blood,hb,rbc,platelets) VALUES(\"".$aadhar."\",\"".$cholestrol."\",\"".$blood."\",\"".$hb."\",\"".$rbc."\",\"".$platelets."\")";


$result=$conn->query($query);

echo $result;
?>