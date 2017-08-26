<?php
	$upload = $_FILES['uploadFile'];
	if($upload['error']==0){
		copy($upload['tmp_name'],"upload/{$upload['name']}")
		echo 'upload ok'
	}


?>