<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>MapApp - Spring Boot + Leaflet</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />

<link href='https://fonts.googleapis.com/css?family=Roboto'
	rel='stylesheet' type='text/css' />
<link href='https://fonts.googleapis.com/css?family=Exo'
	rel='stylesheet' type='text/css' />
</head>
<body>

	<div class="container">

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-5"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">MapApp</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-5">
					<ul class="nav navbar-nav">
						<li><a href="./">Map</a></li>
						<li><a href="./pointList">Point List</a></li>
						<li><a href="./swagger-ui/index.html" target="_blank">Swagger (OpenAPI) UI</a></li>
					</ul>
					<p class="navbar-text navbar-right"></p>
				</div>
			</div>
		</nav>
		    <H1>Home</H1>

		

		<article>
			<header>
				<h1>Map Points</h1>
				<p></p>
			</header>
			<div style="color: red;">${errorMessage}</div>
			<div style="color: green;">${message}</div>

			<table class="table">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">name</th>
						<th scope="col">description</th>
						<th scope="col">category</th>
						<th scope="col">Latitude</th>
						<th scope="col">Longitude</th>
						<th scope="col">photoUrl</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="mapPoint" items="${mapPoints}">
						<tr>
							<td>${mapPoint.id}</td>
							<td>${mapPoint.name}</td>
							<td>${mapPoint.description}</td>
							<td>${mapPoint.category}</td>
							<td>${mapPoint.lat}</td>
							<td>${mapPoint.lng}</td>
							<td>${mapPoint.photoUrl}</td>
							<td>
								<form action="./viewModifyPoint" method="POST">
									<input type="hidden" name="pointId" value="${mapPoint.id}">
									<input type="hidden" name="action" value="modifyPoint">
									<button class="btn" type="submit">Modify Point</button>
								</form>
								<form action="./viewModifyPoint" method="POST">
									<input type="hidden" name="pointId" value="${mapPoint.id}">
									<input type="hidden" name="action" value="deletePoint">
									<button class="btn" type="submit">Delete Point</button>
								</form>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

			<form action="./viewModifyPoint" method="POST">
				<input type="hidden" name="pointId" value="${mapPoint.id}">
				<input type="hidden" name="action" value="newPoint">
				<button class="btn" type="submit">Add Point</button>
			</form>






			<section>
				<p>random text.</p>
			</section>
			<footer> </footer>
			<hr />
		</article>

		<footer style="text-align: center">
			<p>
				<span style="text-decoration: none; color: grey;">/* MapApp -
					<a style="text-decoration: none; color: grey;"
					href="https://github.com/imaginalis"><span
						class="glyphicon glyphicon-star"></span> imaginalis</a> */
				</span>
			</p>
		</footer>

	</div>

</body>
</html>