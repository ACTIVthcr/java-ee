<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculatrice</title>
</head>
<body>
	<p><%
	%>${ message }</p>
	<form action="http://localhost:8080/Calculatrice/" id="calculatriceForm" method="post">
		<input id="nb1" name="nb1" type="number">
			<select id="operation" name="operation">
				<option value="+">+</option>
				<option value="/">/</option>
				<option value="-">-</option>
				<option value="*">*</option>
		</select>
		<input id="nb2" name="nb2" type="number">
		<button type="submit">Envoyer</button>
	</form>
</body>
</html>