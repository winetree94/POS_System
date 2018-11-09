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

<h1>store new</h1>

<form action="/stores" method="post">

	<input type="text" name="store_name">
	<input type="text" name="store_detail">
	<input type="text" name="store_type">
	<input type="text" name="store_address">
	<input type="text" name="store_tel">
	<input type="text" name="store_hour">

	<input type="submit">
</form>

</body>
</html>