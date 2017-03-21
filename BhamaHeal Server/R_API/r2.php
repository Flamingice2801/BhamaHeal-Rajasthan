<?php
$host="localhost";
$uname="root";
$pass="root";
$database="BhamaHeal";
$conn=new mysqli($host,$uname,$pass,$database);
$result=$conn->query("SELECT * FROM agevscore");
$fp = fopen('file.csv', 'w');
fwrite($fp,"Id,Age,Health Score\n");
while($row=$result->fetch_assoc()){
fwrite($fp,$row['Id'].",".$row['Age'].",".$row['Health_Score']."\n");}
fclose($fp);
?>