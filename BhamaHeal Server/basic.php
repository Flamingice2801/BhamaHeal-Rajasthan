<?php
$bhID=$_GET['bhid'];
$aadhar=$_GET['aadhar'];
$name=$_GET['name'];

$host="localhost";
$uname="root";
$pass="root";
$DB_NAME="BhamaHeal";

$conn=new mysqli($host,$uname,$pass,$DB_NAME);

$query="INSERT INTO basic(Bhamashah,aadhar,name) VALUES(\"".$bhID."\",\"".$aadhar."\",\"".$name."\")";


$result=$conn->query($query);
    echo $result;
?>