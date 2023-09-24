<%-- 
    Document   : newjsp
    Created on : 24 Sep 2023, 18:13:41
    Author     : cgallen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%
    String fName = request.getParameter("firstName");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>JSP Example 1:Simple Page url parameters</h1>
        <h1>Hello World!</h1>
        <p>the time is <%= new Date()%> </p>

        <p><a href="./newjsp.jsp?firstName=John">example query ./newjsp.jsp?firstName=John</a> 
        </p>
        
        <p>Hello <strong> <%=fName%></strong></p>
        
        <h1>JSP Example 2: Form Request Examples</h1>
        <!-- starting the href with ./ means you are referring relative to the root of this page -->
        <form action="./newjsp.jsp" method="get">
            <p>Please enter your name:<input type="text" name="firstName" value="" /></p>
            <input type="submit" value="Send to JSP!" />
        </form> 
        <br />
    </body>
</html>