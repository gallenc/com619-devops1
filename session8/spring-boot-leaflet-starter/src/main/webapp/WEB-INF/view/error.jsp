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

        <h1>Error Page</h1>
        <p>Application has encountered an error.</p>
        <p>${error}</p>
        <p>${status}</p>
        <p>Failed URL: ${requestUrl}</p>
        <p>Exception:  ${exception.message}</p>
        <p>Stack trace:</p>
        <p>${strStackTrace}</p>

</body>
</html>