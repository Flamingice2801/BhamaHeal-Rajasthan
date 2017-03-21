<?php
$disease=$_GET['disease'];
$region=$_GET['region'];

$host="localhost";
$uname="root";
$pass="root";
$DB_NAME="BhamaHeal";

$conn=new mysqli($host,$uname,$pass,$DB_NAME);

$query="UPDATE rloc set people=people+1 where disease='".$disease."' and region='".$region."'";
echo $query;
$result=$conn->query($query);
var_dump($result);
?>