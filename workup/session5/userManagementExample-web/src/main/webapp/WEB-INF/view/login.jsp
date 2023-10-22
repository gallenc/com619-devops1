<%-- 
    Document   : content
    Created on : Jan 4, 2020, 11:19:47 AM
    Author     : cgallen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
// request set in controller
//    request.setAttribute("selectedPage","contact");
%>
<jsp:include page="header.jsp" />
<!-- Begin page content -->
<main role="main" class="container">
    <H1>Login</H1>
    <div style="color:red;">${errorMessage}</div>
    <div style="color:green;">${message}</div>

<!--     <form action="./login" method="post"> -->
<!--         <input type="hidden" name="action" value="login"> -->
<!--         <p>Username <input type="text" name="username" ></input></p><BR> -->
<!--         <p>Password <input type="password" name="password" ></input></p> -->
<!--         <p><button type="submit" >Log In</button></p> -->
<!--     </form>  -->

    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
<%--             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
<input name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create a new account</a></h4>
            <h4 class="text-center"><a href="${contextPath}/home">Return to home page</a></h4>
        </div>

    </form>
    
    <a href="./register">Create a new account</a>
</main>


<jsp:include page="footer.jsp" />
