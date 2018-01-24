<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Pagina de clientes</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>
	Add a Film
</h1>

<c:url var="addAction" value="/film/add" ></c:url>

<form:form action="${addAction}" commandName="film">
<table>
	<c:if test="${!empty film.titulo}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="titulo">
				<spring:message text="Titulo"/>
			</form:label>
		</td>
		<td>
			<form:input path="titulo" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="director">
				<spring:message text="Director"/>
			</form:label>
		</td>
		<td>
			<form:input path="director" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="categoria">
				<spring:message text="categoria"/>
			</form:label>
		</td>
		<td>
			<form:input path="categoria" />
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty film.titulo}">
				<input type="submit" class="btn btn-danger"
					value="<spring:message text="Edit Film"/>" />
			</c:if>
			<c:if test="${empty film.titulo}">
				<input type="submit" class="btn btn-danger"
					value="<spring:message text="Add Film"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista de films</h3>
<c:if test="${!empty listFilms}">
	<table class="tg">
	<tr>
		<th width="80">Pelicula ID</th>
		<th width="120">Titulo</th>
		<th width="120">Director</th>
		<th width="120">Categoria</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listFilms}" var="film">
		<tr>
			<td>${film.id}</td>
			<td>${film.titulo}"</td>
			<td>${film.director}</td>
			<td>${film.categoria}</td>
			<td><a href="<c:url value='/edit/${film.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${film.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</div>
  <!-- jQuery first, then Tether, then Bootstrap JS. -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
</body>
</html>
