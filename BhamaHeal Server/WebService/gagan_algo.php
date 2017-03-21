<?php
error_reporting(E_ALL & ~E_NOTICE); ini_set('display_errors', '1');

if(isset($_GET['aadhar'])&&isset($_GET['bhid'])) {
$host="localhost";
$user="root";
$pass="root";
$DB_NAME="BhamaHeal";
$aadhar=$_GET["aadhar"];
$bhid=$_GET["bhid"];
$conn=new mysqli($host,$user,$pass,$DB_NAME);
$query1="SELECT * FROM health_one WHERE aadhar= ".$aadhar. " and bhamashah= ".$bhid;
$result=$conn->query($query1);
$query2="SELECT * FROM health_two WHERE aadhar= ".aadhar. " and bhamashah= ".$bhid;
$result2=$conn->query($query2);
$output2=array();
$row1=$result->fetch_assoc();
$row2=$result2->fetch_assoc();
global  $row ;
global  $row2 ;
global $output ; 
global $finalscore ;
$finalscore=0 ;
function calculatescoreofeye($value)
{
	$value=abs($value);
	$score=10;
	if($value<=3)
	{
		$score=10-($value*0.5);
        echo $score." ";
		return $score;
	}
	else 
	{
	   $score=10-($value*0.7);
       eecho $score." ";
	   return $score;
	}
	
}
function calculatescore($ext1,$ext2,$value)
  { 
    //  echo " value-".$value." " ;  
     $score=10;
     $mean=($ext1+$ext2)/2;
    //  echo $mean ; 

          $range=(($ext2-$mean)/$mean)*100;
          $actualrange=abs((($mean-$value)/$mean)*100);
        //   echo "range-".$range." " ; 
        //   echo "actual-range".$actualrange ;
          if($actualrange<=$range)
          {
             $score=10-($actualrange*0.01);
          }
          else
          {
              $score=10-($actualrange*0.25);
          }
          echo $score." ";
          return $score;
  }
  function healthscore ($i)
  {  
    global $output ;
    global $row ; 
    global $finalscore ;


    //  echo "YO-".$row[$output[$i]]."-".$output[$i]."  " ;
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
      	$finalscore+=calculatescore(70,140,$row[$output[$i]])/count($output);
      }
      else if ($output[$i]=="bmi")
      {
      	$finalscore+=calculatescore(18.5,24.9,$row[$output[$i]])/count($output);
      }
      else if ($output[$i]=="lefteye")
      {
      	$finalscore+=calculatescoreofeye($row[$output[$i]])/count($output);
      }
      else if ($output[$i]=="righteye")
      {
      	$finalscore+=calculatescoreofeye($row[$output[$i]])/count($output);
      }
  }

//$row= array("cholestrol"=>290 , "hb"=>17 , "rbc"=>6, "platelets"=>150000 , "lefteye"=>1, "righteye"=>1, "bmi"=>23, "sugar"=>138) ;
$output=array("cholestrol","hb","rbc","platelets","lefteye","righteye","bmi","sugar");
for($i=0;$i<count($output);$i++){
    // $output2[$i]=row[$output[$i]];
    if(i<4)
    {
    array_push($output2,$row[$output[$i]]);
    }
    else 
    {
    array_push($output2,$row2[$output[$i]]);
    }
    healthscore($i);
}
// var_dump($row);
// var_dump($row2);
// if($finalscore<0)
// {
//    $finalscore=0;
// }
echo round($finalscore, 2); 
}

else "fuck off" ;