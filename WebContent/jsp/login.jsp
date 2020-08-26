<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"> 

<title>Autenticação</title>
</head>
<body>

 	<div class="row">
		<div class="panel panel-default col-md-2 col-md-offset-5">
	          
			<div class="panel-heading">Autenticação</div>
	        
			<div class="panel-body">
	
				<form action="login" method="post" role="form">
				
					<div class="form-group">
						<label for="username">Matrícula</label>
						<input class="form-control" name="username"	type="text" required/>
					</div>
				
					<div class="form-group">
						<label for="password">Senha</label>
						<input class="form-control" name="password" type="password" required/>
					</div>
				
					<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-ok"></span> Autenticar
					</button>
	
				</form>
	
			</div>
		</div>
	</div>
 
</body>
</html>