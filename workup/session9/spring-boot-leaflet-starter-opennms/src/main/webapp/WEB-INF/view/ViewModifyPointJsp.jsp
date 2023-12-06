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

		<article>
			<header>
				<h1>Map Point Create or Update</h1>
			</header>
			<div style="color: red;">${errorMessage}</div>
			<div style="color: green;">${message}</div>

			<form action="./viewModifyPoint" method="POST">
				<table class="table">
					<thead>
						<tr>
							<th>Attribute</th>
							<th>Value</th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td>Id</td>
							<td>${mapPoint.id}</td>
						</tr>
						<tr>
							<td>name</td>
							<td><input type="text" name="pointName"
								value="${mapPoint.name}" /></td>
						</tr>
						<tr>
							<td>description</td>
							<td><input type="text" name="pointDescription"
								value="${mapPoint.description}" /></td>
						</tr>
						<tr>
							<td>category</td>
							<td><input type="text" name="pointCategory"
								value="${mapPoint.category}" /></td>
						</tr>
						<tr>
							<td>Latitude</td>
							<td><input type="text" name="pointlat"
								value="${mapPoint.lat}" /></td>
						</tr>
						<tr>
							<td>Longitude</td>
							<td><input type="text" name="pointlon"
								value="${mapPoint.lng}" /></td>
						</tr>
						<tr>
							<td>photoUrl</td>
							<td>${mapPoint.photoUrl}</td>
						</tr>
					</tbody>
				</table>
				<input type="hidden" name="pointId" value="${mapPoint.id}" />
				<input type="hidden" name="pointphotoUrl" value="${mapPoint.photoUrl}" />
				<input type="hidden" name="action" value="updatePoint">
				<button class="btn" type="submit">Modify / Create Point</button>
			</form>

        <!-- adding photo -->
        <!-- see https://www.codejava.net/frameworks/spring-boot/spring-boot-file-upload-tutorial -->
        <div>
           <label>Photo: </label>
           <img src="./user-photos/${mapPoint.id}/${mapPoint.photoUrl}" alt="${mapPoint.name} ${mapPoint.id} image" width="100" height="100" />
           
           
           <form action="./viewModifyPoint" method="POST" enctype="multipart/form-data">
               <input class="btn" type="file" name="image" accept="image/png, image/jpeg" capture="camera">
               <input type="hidden" name="pointId" value="${mapPoint.id}" />
                <input type="hidden" name="action" value="updatePointPhoto">
               <button class="btn" type="submit" >Update Photo</button>
           </form>
        </div>




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