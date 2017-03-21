<?php

if(isset($_GET['aadhar'])&&isset($_GET['bhid'])){

global  $row ;
global $row2 ; 
global $output ; 
global $finalscore ;

$host="localhost";
$user="root";
$pass="toor";
$DB_NAME="bhamaheal";
$aadhar=$_GET["aadhar"];
$bhid=$_GET["bhid"];

$conn=new mysqli($host,$user,$pass,$DB_NAME);

$query1="SELECT * FROM health_one WHERE aadhar= ".$aadhar." and bhamashah= ".$bhid ;


$query2="SELECT * FROM health_two WHERE aadhar= ".$aadhar." and bhamashah= ".$bhid;


$result=$conn->query($query1);

$result2=$conn->query($query2);
$output2=array();

$row=$result->fetch_assoc();
$row2=$result2->fetch_assoc();

$finalscore=0 ;
function calculatescoreofeye($value)
{
	$score=10;
	if($value<=3)
	{
		$score=10-($value*0.5);
		return $score;
	}
	else 
	{
	    $score=10-($value*0.7);
	    return $score;
	}
	
}
function calculatescore($ext1,$ext2,$value)
  { 
     $score=10;
     $mean=($ext1+$ext2)/2;

          $range=(($ext2-$mean)/$mean)*100;
          $actualrange=abs((($mean-$value)/$mean)*100);

          if($actualrange<=$range)
          {
             $score=10-($actualrange*0.01);
          }
          else
          {
              $score=10-($actualrange*0.25);
          }

          return $score;

  }
  function healthscore ($i)
  {  
    global $output ;
    global $row ;
    global $row2 ;
    global $finalscore ;


      if($output[$i]=="platelets")
      {     
          $finalscore+=calculatescore(150000,450000,$row[$output[$i]]) /count($output);
      }
      else if ($output[$i]=="rbc")
      {
         $finalscore+=calculatescore(4.7,6.1,$row[$output[$i]])/count($output);
 
      }
      else if ($output[$i]=="hb")
      {
         $finalscore+=calculatescore(14,18,$row[$output[$i]])/count($output);

      }
      else if ($output[$i]=="cholestrol")
      {
        $finalscore+=calculatescore(200,300,$row[$output[$i]])/count($output);

      }
      else if ($output[$i]=="sugar")
      {
      	$finalscore+=calculatescore(70,140,$row2[$output[$i]])/count($output);
      }
      else if ($output[$i]=="bmi")
      {
      	$finalscore+=calculatescore(18.5,24.9,$row2[$output[$i]])/count($output);
      }
      else if ($output[$i]=="lefteye")
      {
      	$finalscore+=calculatescoreofeye($row2[$output[$i]])/count($output);
      }
      else if ($output[$i]=="righteye")
      {
      	$finalscore+=calculatescoreofeye($row2[$output[$i]])/count($output);
      }
  }


$output=array("cholestrol","hb","rbc","platelets","lefteye","righteye","bmi","sugar");
for($i=0;$i<count($output);$i++){
    // $output2[$i]=row[$output[$i]];
    if($i<=3)
    array_push($output2,$row[$output[$i]]);
    else
    array_push($output2,$row2[$output[$i]]);

    healthscore($i);
}

echo round($finalscore, 2); 

}
?>