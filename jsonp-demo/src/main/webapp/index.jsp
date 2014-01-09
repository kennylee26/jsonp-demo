<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>JSONP DEMO</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="jsonp" />
<meta http-equiv="description" content="A jsonp webapp demo" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
	var serviceAPI = "http://localhost:8081/jsonp-demo/JsonpService?callBack=?";
	$(document).ready(function() {
		$('#cli').click(function() {
			var _name = $.trim($('#name').val());
			//check
			if (_name == false) {
				alert('Please input your name first!');
				$('#name').focus();
				return;
			}
			$.getJSON(serviceAPI, {
				name : _name
			}).done(function(data) {
				alert(data.msg);
			});
		});
	});
</script>
</head>
<body>
	<div>
		Input your Name: <input name="name" id="name" type="text"></input><input
			id="cli" type="button" value="submit" />
	</div>
</body>
</html>
