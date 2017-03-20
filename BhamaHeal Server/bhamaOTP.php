<?php
$mobile = $_POST['number'];
$otp = rand(1111,9999); // OTP code here.

if(!empty($mobile) && $mobile !== ''){ 
$api_key = '<insert API key here>';
$contacts = $mobile;
$from = 'BMHEAL';
$smsformat = "Bhama Heal OTP is ".$otp;

// Below section should remain constant
$sms_text = urlencode($smsformat);
$ch = curl_init();
curl_setopt($ch,CURLOPT_URL, "http://user.zygontech.com/app/smsapi/index.php");
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, "key=".$api_key."&routeid=261&type=text&contacts=".$contacts."&senderid=".$from."&msg=".$sms_text);
$response = curl_exec($ch);
curl_close($ch);
//echo $response;
echo true;

}else{ 
echo false;
}

?>
