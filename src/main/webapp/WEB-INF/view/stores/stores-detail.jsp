<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
	      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
</head>
<body>

<h1>store detail</h1>

${stores_detail}


<form action="./1" method="post">
	<input type="text" name="store_name" value="">
	<input type="text" name="store_detail" value="">
	<input type="text" name="store_type" value="">
	<input type="text" name="store_address" value="">
	<input type="text" name="store_tel" value="">
	<input type="text" name="store_hour" value="">
	<input type="submit">
</form>

</body>
</html>