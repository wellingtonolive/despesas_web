<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="resources/css/bootstrap.css" rel="stylesheet" />
<link type="text/css" href="resources/css/bootstrap.min.css" rel="stylesheet" />
<title>Formul�rio login</title>
</head>
<body>

	<h2 class="text-center">P&aacute;gina de Login das Despesas</h2>
	<div class="card" style="margin-left: auto; margin-right: auto; width: 30%">
	<form class="container"action="efetuaLogin" method="post">
		<br />Login:<input class="form-control" type="text" name="login" /> <br />
		<br />Senha:<input class="form-control" type="password" name="senha" /> <br />
		<br /><input class="btn btn-primary" type="submit" value="Entrar nas despesas" />
	<br />
	<br />
	</form>
	</div>


</body>
</html>