<?php
	$conn = mysqli_connect('127.0.0.1','root','root','ming');
	$account = $_GET['account'];
	$passwd = $_GET['passwd'];
	$realname = $_GET['realname'];
	$sql="insert into member2(account,passwd,realname)"."values('{$account}','{$passwd}','{$realname}')";
	mysqli_query($conn,$sql);
	if(!mysqli_error()){
		echo 'ok';
		return ;
	}else{
		echo 'xx';
		return ;
	}

?>